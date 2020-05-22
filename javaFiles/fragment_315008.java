public TestClass() {

        //Init.
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textarea = new JTextArea();
        JScrollPane scrollpane = new JScrollPane(textarea);
        panel.add(scrollpane, BorderLayout.CENTER);



        //Text Stuff
        textarea.setFont(textarea.getFont().deriveFont(16f));
        textarea.setText("Change Log: \n V1.0(A): Original encoder \n V1.0(B): Original decoder \n V1.1: Combination of both encoder and decoder \n V1.2: Added a heavier encoding & decoding system \n V1.3: Added an icon \n V1.4: Created an 'Info' page \n V1.5: Added a 'Change Log' page to the 'Info' page \n "
                + "V1.6: Removed the 'Change Log' \n V1.7: Added a 'Change Log' but was not implemented \n V1.8: Added a the 'Change Log' button \n V1.9: Added horizontal and vertical scroll bars to the 'Change Log'");
        textarea.setForeground(Color.BLACK);
        //Dimension d = new Dimension(250, 275);
        //textarea.setPreferredSize(d);


        //Other Stuff
        scrollpane.setViewportView(textarea);
        scrollpane.getPreferredSize();




        //Layout
        //scrollpane.setBounds(new Rectangle(new Point(20, 20), scrollpane.getPreferredSize()));
        //textarea.setBounds(new Rectangle(new Point(20, 23), textarea.getPreferredSize()));

        //Listeners



        //Frame Stuff
        frame.setAlwaysOnTop(true);
        frame.setSize(300, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);


        //Panel Stuff
        frame.add(panel);
        panel.setSize(frame.getSize());
        panel.setBackground(Color.BLUE);
        panel.add(scrollpane);
    }