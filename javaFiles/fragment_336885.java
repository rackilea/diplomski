// class:TextEditor.java

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.text.DefaultEditorKit;

public class TextEditor extends JFrame {
    static int fn = 0;
    private JTextArea area = new JTextArea(20, 120);
    // TextEditor frm = new TextEditor(10,10);

    private JFileChooser dialog = new JFileChooser(System.getProperty("user.dir"));
    private String currentFile = "Untitled";
    private boolean changed = false;
    private JButton a = new JButton("H");
    private JButton b = new JButton("HE");
    private JButton c = new JButton("O");

    public TextEditor() {
        setLayout(new FlowLayout());
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(scroll, BorderLayout.CENTER);
        add(a);// add the button to the JFrame
        add(b);
        add(c);
        JMenuBar JMB = new JMenuBar();
        setJMenuBar(JMB);
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMB.add(file);
        JMB.add(edit);

        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CircleComponent a1 = new CircleComponent();
                a1.a2();
                selectionButtonPressed();
            }

            private void selectionButtonPressed() {
            }
        });
        file.add(New);
        file.add(Open);
        file.add(Save);
        file.add(SaveAs);
        file.add(Quit);
        file.addSeparator();

        for (int i = 0; i < 4; i++)
            file.getItem(i).setIcon(null);

        edit.add(Cut);
        edit.add(Copy);
        edit.add(Paste);

        edit.getItem(0).setText("Cut out");
        edit.getItem(1).setText("Copy");
        edit.getItem(2).setText("Paste");

        JToolBar tool = new JToolBar();
        add(tool, BorderLayout.NORTH);
        tool.add(New);
        tool.add(Open);
        tool.add(Save);
        tool.addSeparator();

        JButton cut = tool.add(Cut), cop = tool.add(Copy), pas = tool.add(Paste);

        cut.setText(null);
        cut.setIcon(new ImageIcon("cut.gif"));
        cop.setText(null);
        cop.setIcon(new ImageIcon("copy.gif"));
        pas.setText(null);
        pas.setIcon(new ImageIcon("paste.gif"));

        // Save.setEnabled(false);
        // SaveAs.setEnabled(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        area.addKeyListener(k1);
        setTitle(currentFile);
        setVisible(true);
    }

    private KeyListener k1 = new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            changed = true;
            Save.setEnabled(true);
            SaveAs.setEnabled(true);
        }
    };
    Action New = new AbstractAction("New", new ImageIcon("new.gif")) {
        public void actionPerformed(ActionEvent e) {
            saveOld();
            currentFile = "Untitled";
            setTitle(currentFile);
            changed = false;
            area.setText(null);
        }
    };
    Action Open = new AbstractAction("Open", new ImageIcon("open.gif")) {
        public void actionPerformed(ActionEvent e) {
            saveOld();
            if (dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                readInFile(dialog.getSelectedFile().getAbsolutePath());
            }
            SaveAs.setEnabled(true);
        }
    };
    Action Save = new AbstractAction("Save", new ImageIcon("save.gif")) {
        public void actionPerformed(ActionEvent e) {
            if (!currentFile.equals("Untitled"))
                saveFile(currentFile);
            else
                saveFileAs();
        }
    };
    Action SaveAs = new AbstractAction("Save as...") {
        public void actionPerformed(ActionEvent e) {
            saveFileAs();
        }
    };
    Action Quit = new AbstractAction("Quit") {
        public void actionPerformed(ActionEvent e) {
            saveOld();
            System.exit(0);
        }
    };

    private TextEditor(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

    ActionMap m = area.getActionMap();
    Action Cut = m.get(DefaultEditorKit.cutAction);
    Action Copy = m.get(DefaultEditorKit.copyAction);
    Action Paste = m.get(DefaultEditorKit.pasteAction);

    private void saveFileAs() {
        if (dialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
            saveFile(dialog.getSelectedFile().getAbsolutePath());
    }

    private void saveOld() {
        if (changed) {
            if (JOptionPane.showConfirmDialog(this, "Would you like to save " + currentFile + " ?", "Save", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                saveFile(currentFile);
        }
    }

    private void readInFile(String fileName) {
        try {
            FileReader r = new FileReader(fileName);
            area.read(r, null);
            r.close();
            currentFile = fileName;
            setTitle(currentFile);
            changed = false;
        } catch (IOException e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Editor can't find the file called " + fileName);
        }
    }

    private void saveFile(String fileName) {
        try {
            FileWriter w = new FileWriter(fileName);
            area.write(w);
            w.close();
            currentFile = fileName;
            setTitle(currentFile);
            changed = false;
            Save.setEnabled(false);
        } catch (IOException e) {
        }
    }

    public static void main(String[] arg) {
        new TextEditor();
    }

    private void setsize(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

    private void a() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

    private void a2() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

}

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CircleComponent extends JPanel {
    Ellipse2D.Double circle;

    public CircleComponent(int radius) {
        circle = new Ellipse2D.Double(0, 0, radius, radius);
        setOpaque(false);
    }

    CircleComponent() {
    }

    public Dimension getPreferredSize() {
        Rectangle bounds = circle.getBounds();
        return new Dimension(bounds.width, bounds.height);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getForeground());
        g2.fill(circle);

    }

    /*
     * public int getWidth(int aWidth) { width = aWidth; return width; }
     */

    public void a2() {
        // Create a panel using a null layout so we can add components at random positions
        final JPanel center = new JPanel();
        center.setLayout(null);

        JButton button = new JButton("Draw");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String x = JOptionPane.showInputDialog("X Coordinate", "Enter an x coordinate");
                try {
                    int xCoord = Integer.parseInt(x);
                    String y = JOptionPane.showInputDialog("Y Coordinate", "Enter a y coordinate");
                    int yCoord = Integer.parseInt(y);
                    String width = JOptionPane.showInputDialog("Radius", "Enter the length of the radius");
                    int radius = Integer.parseInt(width);
                    CircleComponent component = new CircleComponent(radius);
                    component.setLocation(xCoord, yCoord);
                    component.setSize(component.getPreferredSize());
                    center.add(component);
                    center.repaint();
                } catch (NumberFormatException ex) {

                    System.err.println("Ilegal input");
                }
            }
        });

        JFrame frame = new JFrame();
        frame.add(center, BorderLayout.CENTER);
        frame.add(button, BorderLayout.NORTH);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void addActionListener() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

    void addActionListener(ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

    /*
     * CircleComponent() { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose
     * Tools | Templates. }
     * 
     * CircleComponent() { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose
     * Tools | Templates. }
     * 
     * CircleComponent() { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose
     * Tools | Templates. }
     */
}