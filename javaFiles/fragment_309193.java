import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class PictureViewer {
    class PauseAction extends AbstractAction {
        public void actionPerformed(ActionEvent arg0) {
            pauseViewer = !pauseViewer;
        }
    }

    class QuitAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            stopViewer = true;
            pauseViewer = true;
            setNextToView();
            System.exit(0);
        }
    }

    static Double height;
    static final String newline = System.getProperty("line.separator");
    static boolean pauseViewer = false;
    static Dimension screensize = new Dimension();
    static boolean stopViewer = false;
    static JFrame viewer;
    static Double width;

    JLabel area = new JLabel("", JLabel.CENTER);
    int currentPic = 0;
    File dir = new File(".");
    BufferedImage image;    
    String path;
    Action pauseAction;
    int pauseTime = 5;
    Action quitAction;
    private JScrollPane scrollPane = new JScrollPane(area,  JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    ArrayList<File> thesePictures;

    private void displayGUI() {
        //Create and set up the window.
        viewer = new JFrame("Picture Viewer");
        viewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewer.setUndecorated(true);  //Remove the minimize, maximize and close buttons entirely.

        //Get the list of files to display.
        initialize();

        //Set up the content pane.
        addComponents();
        viewer.setPreferredSize(screensize);

        //Display the window.
        viewer.pack();
        viewer.setVisible(true);

        //Start showing pictures.
        while (!stopViewer) {
            try {
                showPictures();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Perform cleanup
        setNextToView();
    }

    public static void main(String[] args) throws IOException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new PictureViewer().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }

    public void addComponents() {
        //Set up actions.
        pauseAction = new PauseAction();
        quitAction = new QuitAction();
        scrollPane.getInputMap().put(KeyStroke.getKeyStroke("P"), "doPauseAction");
        scrollPane.getActionMap().put("doPauseAction", pauseAction);
        scrollPane.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "doQuitAction");
        scrollPane.getActionMap().put("doQuitAction", quitAction);
        scrollPane.getViewport().setBackground(Color.BLACK);
        viewer.add(scrollPane);
    }

    public ArrayList<File> getPictures(File dir) {
        ArrayList<File> listFiles = new ArrayList<File>(Arrays.asList(dir.listFiles()));
        int selectThis = (int) (Math.random() * listFiles.size());
        boolean emptyList = true;

        if (listFiles.get(selectThis).isDirectory()) {
            return getPictures(listFiles.get(selectThis));
        } else {
            //if the selected file is not a directory, go through the list of files and remove any directories.

            ArrayList<File> newList = new ArrayList<File>();

            for (File thisFile : listFiles) {
                if (!thisFile.isDirectory() && !thisFile.getName().contains(".next") && !thisFile.getName().contains(".jar")) {
                    newList.add(thisFile);
                }
            }

            listFiles = newList;
        }

        return listFiles;
    }

    public void initialize() {
        screensize = Toolkit.getDefaultToolkit().getScreenSize();
        height = screensize.getHeight();
        width = screensize.getWidth();
        String filePath = new File(".").getAbsolutePath();
        filePath = filePath.substring(0, filePath.length() - 1);
        String directory = "";

        while (thesePictures == null || thesePictures.size() == 0) {
            thesePictures = getPictures(dir);
        }

        String absolutePath = thesePictures.get(0).getAbsolutePath();
        path = absolutePath.substring(0,absolutePath.lastIndexOf(File.separator));

        //Look to see if the .next file exists.  If so, read in the file object.  If not, set the index to 0.
        File checkFile = new File(path + "\\.next");

        if (checkFile.exists()) {
            try {
                InputStream inputFile = new FileInputStream(path + "\\.next");
                InputStream buffer = new BufferedInputStream(inputFile);
                ObjectInput input = new ObjectInputStream(buffer);
                File lastViewedPic = (File) input.readObject();

                if (thesePictures.contains(lastViewedPic)) {
                    currentPic = thesePictures.indexOf(lastViewedPic);
                } else {
                    currentPic = 0;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Look at " + path + "\\.next");
                System.exit(-1);
            }
        } else {
            currentPic = 0;
        }
    }

    public void readInFile(String fileName) {
        File file = new File(fileName);
        if(file.isFile()) {
            try {
                image = ImageIO.read(file);

                if (image.getWidth() > width || image.getHeight() > height) {
                    BufferedImage newImage = new BufferedImage(width.intValue(), height.intValue(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = newImage.createGraphics();
                    g.drawImage(image, 0, 0, width.intValue(), height.intValue(), null);
                    g.dispose();
                    image = newImage;
                }
            } catch (IOException e) {
                showMessageDialog(viewer,"Does not compute !","No file read or found",INFORMATION_MESSAGE);
                e.printStackTrace();
            } catch (Exception e) {
                showMessageDialog(viewer, "Problem: " + e.getLocalizedMessage());
            }
        }
    }

    public void setImage(JLabel area){
        ImageIcon icon = new ImageIcon(image);
        area.setIcon(icon);
        viewer.repaint();
    }

    protected void setNextToView() {
        //See if the next picture to view file exists.  If not, create it.
        File checkFile = new File(path + "\\.next");

        if (!checkFile.exists()) {
            try {
                checkFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream outputFile = new FileOutputStream(path + "\\.next");
            ObjectOutputStream writer = new ObjectOutputStream(outputFile);
            writer.writeObject(thesePictures.get(currentPic));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showPictures() throws InterruptedException {
        while (!pauseViewer) {
            //If we reach the last file in the directory, switch to another directory (it could be the same directory).
            if (currentPic + 1 == thesePictures.size()) {
                currentPic = 0;
                thesePictures = new ArrayList<File>();

                while (thesePictures == null || thesePictures.size() == 0) {
                    thesePictures = getPictures(dir);
                }
            } else {
                currentPic += 1;
            }

            readInFile(thesePictures.get(currentPic).getAbsolutePath());
            setImage(area);
            TimeUnit.SECONDS.sleep(pauseTime);
        }
    }
}