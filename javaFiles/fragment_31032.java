import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

public class BasicCopy extends JFrame {

    private JPanel contentPane;
    private JTextArea txtCopiedDirs;
    private JButton btnCancel;
    private JProgressBar progressBar;
    private JLabel lblCopying;
    private String mainDrive;
    private String backupDrive;
    private String username;
    private String backupDir;
    long totalSize = 0L;        //total size of directories/files
    long currentSize = 0L;      //current size of files counting up to ONE_PERCENT
    long currentPercent = 0L;   //current progress in %
    long ONE_PERCENT;       //totalSize / 100
    Task task;

    public BasicCopy() {
    }

    public BasicCopy(String inDrive, String outDrive, String username, long space) {
        mainDrive = inDrive;
        backupDrive = outDrive;
        this.username = username;
        totalSize = space * 1048576;
        ONE_PERCENT = totalSize / 100;
        createGUI();
    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Backup Progress");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        txtCopiedDirs = new JTextArea(10, 50);
        txtCopiedDirs.setEditable(false);
        contentPane.add(new JScrollPane(txtCopiedDirs));

        JPanel controls = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(4, 4, 4, 4);

        lblCopying = new JLabel("Now backing up your files....");
        contentPane.add(lblCopying, gbc);

        gbc.gridy++;

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        contentPane.add(progressBar, gbc);

        gbc.gridy++;

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
        controls.add(btnCancel, gbc);
        contentPane.add(controls, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);
        task = new Task();
        task.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
                    progressBar.setValue((int) evt.getNewValue());
                }
            }
        });
        task.execute();
    }

    /**
     * Swing Worker class
     */
    class Task extends SwingWorker<Void, String> {

        @Override
        public Void doInBackground() throws Exception {
            setProgress(0);

            //Create Backup Directory
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy_HMMSS");
            String timestamp = sdf.format(date);
            backupDir = backupDrive + ":\\" + "Backup_" + timestamp;
            File backupDirectory = new File(backupDir);
            backupDirectory.mkdir();

            //Copy Files
            //Main directories
            String pics = mainDrive + ":\\Users\\" + username + "\\Pictures\\";
            String docs = mainDrive + ":\\Users\\" + username + "\\Documents\\";
            String vids = mainDrive + ":\\Users\\" + username + "\\Videos\\";
            String musc = mainDrive + ":\\Users\\" + username + "\\Music\\";
            //Backup directories
            String bkPics = backupDir + "\\Pictures\\";
            String bkDocs = backupDir + "\\Documents\\";
            String bkVids = backupDir + "\\Documents\\";
            String bkMusc = backupDir + "\\Pictures\\";

            String[] directories = {pics, docs, vids, musc};
            String[] bkDirectories = {bkPics, bkDocs, bkVids, bkMusc};

            //Loop through directories and copy files
            for (int i = 0; i < directories.length; i++) {
                File dir = new File(directories[i]);
                File dest = new File(bkDirectories[i]);
                for (File file : dir.listFiles()) {
                    try{
                    if (file.isFile()) {
                        FileUtils.copyFileToDirectory(file, dest);
                        publish(file.getAbsolutePath() + "\n");
                    } else if (file.isDirectory()) {
                        FileUtils.copyDirectoryToDirectory(file, dest);
                        Thread.sleep(1000);
                        publish(file.getAbsolutePath() + "\n");
                    }
                    if (getDirSize(file) >= ONE_PERCENT) {
                        currentPercent = getDirSize(file) / ONE_PERCENT;
                        setProgress((int) currentPercent);
                        currentSize = 0;
                    } else {
                        currentSize = currentSize + getDirSize(file);
                        if (currentSize >= ONE_PERCENT) {
                            currentPercent = currentSize / ONE_PERCENT;
                            currentPercent++;
                            setProgress((int) currentPercent);
                            currentSize = 0;
                        }
                    }
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        public void process(List<String> chunks) {
            for (String path : chunks) {
                txtCopiedDirs.append(path);
            }
        }

        @Override
        public void done() {
            closeWindow();
        }
    }

    public static Long getDirSize(File file) {
        long size = 0L;

        if (file.isFile() && file != null) {
            size += file.isDirectory() ? getDirSize(file) : file.length();
        } else if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                size += f.isDirectory() ? getDirSize(f) : file.length();
            }
        }
        return size;
    }

    /* Close current window */
    public void closeWindow() {
        WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
        System.exit(0);
    }
}