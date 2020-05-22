JFrame frame = new JFrame();

    frame.setLayout(new GridLayout(1, 2));
    JPanel leftPanel = new JPanel(new GridLayout(3, 3));
    for(int i=0;i<9;i++)

    {
        JButton button = new JButton();
        button.setText(i+"");
        leftPanel.add(button);
    }
    frame.add(leftPanel);
    JPanel rightPanel = new JPanel();
     BoxLayout layout = new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS);
     rightPanel.setLayout(layout);

     JButton button = new JButton("Submit");
         button.setAlignmentX(
     Component.CENTER_ALIGNMENT);
     rightPanel.add(Box.createVerticalGlue()); //Ensure this order
     rightPanel.add(button);
     rightPanel.add(Box.createVerticalGlue());


    frame.add(rightPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);