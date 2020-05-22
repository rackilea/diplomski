package com.cooksys.assessment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;

public class Window {

    private JFrame frame;

    /**
     * Launch the application. The main method is the entry point to a Java
     * application. For this assessment, you shouldn't have to add anything to
     * this.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Window window = new Window();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application. This is the constructor for this Window class.
     * All of the code here will be executed as soon as a Window object is made.
     */
    public Window() {
        initialize();
    }

    /**
     * Initialize the contents of the frame. This is where Window Builder will
     * generate its code.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 479);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] values = new String[]{"Case", "Motherboard", "CPU", "RAM", "GPU", "HDD", "PSU"};

        // using default list model.
        DefaultListModel model_list = new DefaultListModel();
        DefaultListModel model_list_1 = new DefaultListModel();

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mntmLoad = new JMenuItem("Load");
        mnFile.add(mntmLoad);

        JMenuItem mntmSave = new JMenuItem("Save");
        mnFile.add(mntmSave);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mnFile.add(mntmExit);
        frame.getContentPane().setLayout(null);

        JList list = new JList();
        JList list_1 = new JList();

        JButton remove = new JButton("<<");
        remove.setBounds(173, 222, 79, 23);
        frame.getContentPane().add(remove);

        JButton Add = new JButton(">>");
        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get list of selected values and for each one of them do following
                list.getSelectedValuesList().stream().forEach((data) -> {
                    // moving data
                    model_list_1.addElement(data);
                    // remove from other side
                    model_list.removeElement(data);
                });
                // refreshing the view after changes
                list.revalidate();
                list_1.revalidate();
            }
        });

        Add.setBounds(173, 188, 79, 23);
        frame.getContentPane().add(Add);

        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setFont(new Font("Tahoma", Font.PLAIN, 16));
        list.setBounds(0, 0, 161, 419);
        list.setModel(model_list);
        frame.getContentPane().add(list);
                    list_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list_1.setBounds(262, 0, 172, 419);
        list_1.setModel(model_list_1);
        frame.getContentPane().add(list_1);                

        // Add values to list using list_model
        for (String value : values) {
            model_list.addElement(value);
        }

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list_1.getSelectedValuesList().stream().forEach((data) -> {
                    model_list.addElement(data);
                    model_list_1.removeElement(data);
                });
                list.revalidate();
                list_1.revalidate();
            }
        });       

    } 
}