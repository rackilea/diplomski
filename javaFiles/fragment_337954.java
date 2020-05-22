/*
     * jsch-0.1.50 - MyPane.java, Feb 3, 2014 3:05:03 PM
     * 
     * Copyright 2014 Varra Ltd, Inc. All rights reserved.
     * Varra proprietary/confidential. Use is subject to license terms.
     */
    package com.varra.threading.voltaile;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.JTextField;

    /**
     * TODO Description go here.
     * 
     * @author <a href="mailto:varra@outlook.com">Rajakrishna V.
     *         Reddy</a>
     * @version 1.0
     * 
     */
    public class MyPane extends JPanel
    {

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = 3089223598850357054L;

        /** The tf. */
        final JTextField tf = new JTextField(30);

        /** The button. */
        final JButton button = new JButton("BUTTON");

        /**
         * Instantiates a new my pane.
         */
        public MyPane()
        {
            add(tf);
            add(button);
            button.setEnabled(false);
            new Thread(target).start();
            tf.addActionListener(actionListener);
        }

        final ActionListener actionListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (e.getActionCommand().equalsIgnoreCase("Enable"))
                {
                    button.setEnabled(true);
                }
                else if (e.getActionCommand().equalsIgnoreCase("Disable"))
                {
                    button.setEnabled(false);
                }
            }
        };

        final Runnable target = new Runnable()
        {

            public void run()
            {
                while (true)
                {
                    final ActionListener[] listeners = tf.getActionListeners();
                    for (ActionListener listener : listeners)
                    {
                        if (tf.getText().trim().length() > 0)
                        {
                            final ActionEvent event = new ActionEvent(tf, 1, "Enable");
                            listener.actionPerformed(event);
                        }
                        else
                        {
                            final ActionEvent event = new ActionEvent(tf, 1, "Disable");
                            listener.actionPerformed(event);
                        }
                    }
                }
            }
        };

        /**
         * Entry point to the entire application, contains the list of args to pass
         * the user defined values.
         * 
         * @param args
         *            the arguments
         */
        public static void main(String... args)
        {
            final JFrame frame = new JFrame();
            frame.getContentPane().add(new MyPane());
            frame.setSize(800, 600);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }