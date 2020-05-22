package com.ggl.testing;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class StudentDataEditor implements Runnable {

    private static final Insets normalInsets = new Insets(10, 10, 0, 10);
    private static final Insets topInsets = new Insets(30, 10, 0, 10);

    private Student student;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new StudentDataEditor());
    }

    public StudentDataEditor() {
        this.student = new Student("00000017108", "Sutandi",
                "Information Systems", 2);
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Student Data Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createMainPanel());
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(createTitlePanel());
        panel.add(createStudentPanel());
        panel.add(createMPPanel());
        panel.add(Box.createVerticalStrut(30));
        panel.add(createEmailPanel());
        panel.add(Box.createVerticalStrut(10));

        return panel;
    }

    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();

        JLabel titleLabel = new JLabel("CEK NILAI");
        titleLabel.setFont(titleLabel.getFont().deriveFont(24F));

        panel.add(titleLabel);

        return panel;
    }

    private JPanel createStudentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel idLabel = new JLabel("ID:");
        addComponent(panel, idLabel, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField idTextField = new JTextField(15);
        idTextField.setEditable(false);
        idTextField.setText(student.getId());
        addComponent(panel, idTextField, 1, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel jurusanLabel = new JLabel("Jurusan:");
        addComponent(panel, jurusanLabel, 2, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField jurusanTextField = new JTextField(15);
        jurusanTextField.setEditable(false);
        jurusanTextField.setText(student.getJurusan());
        addComponent(panel, jurusanTextField, 3, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel nameLabel = new JLabel("Name:");
        addComponent(panel, nameLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField nameTextField = new JTextField(15);
        nameTextField.setEditable(false);
        nameTextField.setText(student.getName());
        addComponent(panel, nameTextField, 1, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel semesterLabel = new JLabel("Semester:");
        addComponent(panel, semesterLabel, 2, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField semesterTextField = new JTextField(15);
        semesterTextField.setEditable(false);
        semesterTextField.setText(Integer.toString(student.getSemester()));
        addComponent(panel, semesterTextField, 3, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        return panel;
    }

    private JPanel createMPPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel mp1Label = new JLabel("MP1");
        addComponent(panel, mp1Label, 0, gridy, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField mp1TextField = new JTextField(25);
        addComponent(panel, mp1TextField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel mp2Label = new JLabel("MP2");
        addComponent(panel, mp2Label, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField mp2TextField = new JTextField(25);
        addComponent(panel, mp2TextField, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel mp3Label = new JLabel("MP3");
        addComponent(panel, mp3Label, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField mp3TextField = new JTextField(25);
        addComponent(panel, mp3TextField, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel mp4Label = new JLabel("MP4");
        addComponent(panel, mp4Label, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField mp4TextField = new JTextField(25);
        addComponent(panel, mp4TextField, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel mp5Label = new JLabel("MP5");
        addComponent(panel, mp5Label, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField mp5TextField = new JTextField(25);
        addComponent(panel, mp5TextField, 1, gridy++, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        return panel;
    }

    private JPanel createEmailPanel() {
        JPanel panel = new JPanel();

        JButton submitButton = new JButton("Send to my email");

        panel.add(submitButton);

        return panel;
    }

    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
            int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 0.0D, 0.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    public class Student {
        private final int semester;

        private final String id;
        private final String name;
        private final String jurusan;

        public Student(String id, String name, String jurusan, int semester) {
            this.id = id;
            this.name = name;
            this.jurusan = jurusan;
            this.semester = semester;
        }

        public int getSemester() {
            return semester;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getJurusan() {
            return jurusan;
        }

    }

}