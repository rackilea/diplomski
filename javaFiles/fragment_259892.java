import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class NewFamilyTree {

    private JFrame frame;
    private JPanel panel_1;
    private JScrollPane scrollPane;
    private JTabbedPane tabbedPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewFamilyTree window = new NewFamilyTree();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    /**
     * Create the application.
     */
    public NewFamilyTree() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("New family tree");
        frame.getContentPane().setBackground(new Color(135, 206, 250));
        frame.setBounds(100, 100, 906, 569);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 144, 255));
        frame.getContentPane().add(panel, BorderLayout.EAST);
        panel.setLayout(new MigLayout("", "[]", "[][][][][][][][]"));

        JButton newPersonButton = new JButton("New Person");
        newPersonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Data data = NewPerson.createPerson(frame);
                if (data != null) {
                    JLabel lblHomer = new JLabel(data.names);
//                    lblHomer.setIcon(new ImageIcon("C:\\Users\\Tinmar\\Desktop\\HomerSimpson3.gif"));
                    panel_1.add(lblHomer, "cell 7 5");
                    panel_1.revalidate();
                }
            }
        });
        panel.add(newPersonButton, "cell 0 5");

        JButton btnNewButton_1 = new JButton("New button");
        panel.add(btnNewButton_1, "cell 0 6");

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        scrollPane = new JScrollPane();
        tabbedPane.addTab("Tree", null, scrollPane, null);

        panel_1 = new JPanel();
        scrollPane.setViewportView(panel_1);
        panel_1.setLayout(new MigLayout("", "[][][][][][][][]", "[][][][][][]"));

//        JLabel lblHomer = new JLabel("Homer");
//        lblHomer.setIcon(new ImageIcon("C:\\Users\\Tinmar\\Desktop\\HomerSimpson3.gif"));
//        panel_1.add(lblHomer, "cell 7 5");
        JScrollPane scrollPane_1 = new JScrollPane();
        tabbedPane.addTab("Info", null, scrollPane_1, null);

        frame.repaint();

    }
//
//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    NewPerson window = new NewPerson();
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    public static class NewPerson extends JPanel {

        private JTextField textFieldNames;
        private JButton selectPictureButton;
        private JLabel labelDateOfBirth;
        private JTextField textFieldDateOfBirth;
        private JLabel labelShortBio;
        private JTextArea textAreaBio;
        private JLabel labelSelectPicture;
        private JButton buttonAdd;
        private String fileID;

        private Data data;

        /**
         * Create the application.
         */
        private NewPerson() {
            initialize();
        }

        public static Data createPerson(Component comp) {
            NewPerson newPerson = new NewPerson();
            Window win = SwingUtilities.getWindowAncestor(comp);
            JDialog dialog = null;
            if (win instanceof Frame) {
                dialog = new JDialog((Frame) win, "New person", true);
            } else if (win instanceof Dialog) {
                dialog = new JDialog((Dialog) win, "New person", true);
            } else {
                dialog = new JDialog((Frame) null, "New person", true);
            }
            newPerson.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object source = e.getSource();
                    if (source instanceof Component) {
                        Window win = SwingUtilities.getWindowAncestor((Component) source);
                        win.dispose();
                    }
                }
            });
            dialog.add(newPerson);
            dialog.pack();
            dialog.setLocationRelativeTo(comp);
            dialog.setVisible(true);

            return newPerson.getData();
        }

        public void addActionListener(ActionListener listener) {
            listenerList.add(ActionListener.class, listener);
        }

        protected void fireActionPerformed() {
            ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
            if (listeners != null && listeners.length > 0) {
                ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "created");
                for (ActionListener listener : listeners) {
                    listener.actionPerformed(evt);
                }
            }
        }

        public Data getData() {
            return data;
        }

        /**
         * Initialize the contents of the frame.
         */
        private void initialize() {
            setBackground(new Color(135, 206, 250));
            setLayout(new MigLayout("", "[][][grow]", "[][][][grow][][][]"));

            JLabel labelNames = new JLabel("Name and Surname:");
            add(labelNames, "cell 1 1,alignx trailing");

            textFieldNames = new JTextField();
            add(textFieldNames, "cell 2 1,growx");
            textFieldNames.setColumns(10);

            labelDateOfBirth = new JLabel("Date of birth:");
            add(labelDateOfBirth, "cell 1 2,alignx center,aligny center");

            textFieldDateOfBirth = new JTextField();
            add(textFieldDateOfBirth, "cell 2 2,growx");
            textFieldDateOfBirth.setColumns(10);

            labelShortBio = new JLabel("Bio:");
            add(labelShortBio, "cell 1 3,alignx center,aligny center");

            textAreaBio = new JTextArea();
            add(textAreaBio, "cell 2 3,grow");

            labelSelectPicture = new JLabel("Select picture:");
            add(labelSelectPicture, "cell 1 4,alignx center,aligny center");

            selectPictureButton = new JButton("...");
            selectPictureButton.setBackground(new Color(30, 144, 255));
            selectPictureButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.home") + "\\Desktop"));

                    chooser.setDialogTitle("Select Location");
                    chooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
                    chooser.setAcceptAllFileFilterUsed(false);

                    if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        fileID = chooser.getSelectedFile().getPath();
                        // txtField.setText(fileID);
                    }

                }
            });
            add(selectPictureButton, "cell 2 4");

            buttonAdd = new JButton("Add");
            buttonAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    String names = textFieldNames.getText();
                    String dateBirth = textFieldDateOfBirth.getText();
                    String bio = textAreaBio.getText();

                    data = new Data(names, dateBirth, bio, fileID);
                    fireActionPerformed();
                }
            });
            buttonAdd.setBackground(new Color(30, 144, 255));
            add(buttonAdd, "cell 2 6,grow");
        }

    }

    public static class Data {

        private final String names;
        private final String dateBirth;
        private final String bio;
        private final String fileID;

        private Data(String names, String dateBirth, String bio, String fileID) {
            this.names = names;
            this.dateBirth = dateBirth;
            this.bio = bio;
            this.fileID = fileID;
        }

    }

}