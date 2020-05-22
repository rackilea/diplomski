import javax.swing.*;

import java.awt.*;

public class StickyNotes {

    private JMenuBar getMenuBar()
    {
        JMenuBar menubar = new JMenuBar();
        JMenu filemenu = new JMenu("File");
        filemenu.add(new JSeparator());
        JMenu editmenu = new JMenu("Edit");
        editmenu.add(new JSeparator());
        JMenuItem fileItem1 = new JMenuItem("New");
        JMenuItem fileItem2 = new JMenuItem("Open");
        JMenuItem fileItem3 = new JMenuItem("Close");
        fileItem3.add(new JSeparator());
        JMenuItem fileItem4 = new JMenuItem("Save");
        JMenuItem editItem1 = new JMenuItem("Cut");
        JMenuItem editItem2 = new JMenuItem("Copy");
        editItem2.add(new JSeparator());
        JMenuItem editItem3 = new JMenuItem("Paste");
        JMenuItem editItem4 = new JMenuItem("Insert");
        filemenu.add(fileItem1);
        filemenu.add(fileItem2);
        filemenu.add(fileItem3);
        filemenu.add(fileItem4);
        editmenu.add(editItem1);
        editmenu.add(editItem2);
        editmenu.add(editItem3);
        editmenu.add(editItem4);
        menubar.add(filemenu);
        menubar.add(editmenu);

        return menubar;
    }

    private void createAndShowGUI() {

        // Create and set up the window.
        JFrame frame = new JFrame("Java Sticky Notes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Add Label
        JLabel label = new JLabel("Type Below");
        frame.getContentPane().add(label);

        // Add Main Menu
        frame.setJMenuBar(getMenuBar());

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public Container createContentPane() {
        // Create the content-pane-to-be.
        JPanel jplContentPane = new JPanel(new BorderLayout());
        jplContentPane.setLayout(new BorderLayout());
        jplContentPane.setOpaque(true);
        return jplContentPane;
    }

    public static void main(String[] args) {
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StickyNotes().createAndShowGUI();
            }
        });
    }
}