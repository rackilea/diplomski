// Change the name to whatever you want
        JFrame frame2 = new JFrame("FRAME 2");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        frame2.setLocationByPlatform(true);

        JPanel contentPane2 = new JPanel();
        contentPane2.setBackground(Color.DARK_GRAY);
        JButton hideButton = new JButton("Exit FRAME 2");
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText("Text Example");
        // Hide or exit or quit, or add whatever you want to this frame
        contentPane2.add(hideButton);
        contentPane2.add(textArea);
        frame2.getContentPane().add(contentPane2);
        frame2.setSize(300, 300);
        frame2.setVisible(true);
    }