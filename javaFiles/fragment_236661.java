import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Browse {
static class CopierThread extends Thread {
    private final Component gui_;

    private final File source_;

    private final File dest_;


    CopierThread(Component gui, File source, File dest) {
        gui_ = gui;
        source_ = source;
        dest_ = dest;
    }


    @Override
    public void run() {
        try {
            copyDirectory(source_, dest_);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(gui_, "The copy of "
                    + source_.getAbsolutePath() + " to "
                    + dest_.getAbsolutePath()
                    + " failed. See console for more details.",
                    "Copy failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}


public static void main(String arg[]) {
    final JFrame frame1 = new JFrame();
    JPanel panel1 = new JPanel();
    JButton button1 = new JButton("press");
    frame1.add(panel1);
    frame1.setSize(400, 400);
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setVisible(true);
    panel1.add(button1);
    button1.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("choosertitle");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                System.out.println("getCurrentDirectory(): "
                        + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : "
                        + chooser.getSelectedFile());

                File source = chooser.getSelectedFile();
                File dest = new File("C:/Users/David/Desktop/test");
                Thread thread = new CopierThread(frame1, source, dest);
                thread.start();
            } else {
                System.out.println("No Selection ");
            }
        }
    });
}


public static void copyDirectory(File sourceDir, File destDir) throws IOException {
    if (!destDir.exists()) {
        destDir.mkdir();
    }
    File[] children = sourceDir.listFiles();
    for(File sourceChild:children) {
        String name = sourceChild.getName();
        File destChild = new File(destDir, name);
        if (sourceChild.isDirectory()) {
            copyDirectory(sourceChild, destChild);
        } else {
            copyFile(sourceChild, destChild);
        }
    }
}


public static void copyFile(File source, File dest) throws IOException {
    if (!dest.exists()) {
        dest.createNewFile();
    }
    InputStream in = null;
    OutputStream out = null;
    try {
        in = new FileInputStream(source);
        try {
            out = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int len;
            while( (len = in.read(buf)) != -1 ) {
                out.write(buf, 0, len);
            }
        } finally {
            if (out != null) out.close();
        }
    } finally {
        if (in != null) in.close();
    }
}
}