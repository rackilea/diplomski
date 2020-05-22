public static void main(String[] args) {
        //Create the frame
        JFrame frame = new JFrame();
        //Set the frame's size
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Roaches!");
        //Create the button
        JButton button = new JButton("Multiply Roaches!");

        Roach roach = new Roach();

        button.addActionListener(roach);
        JPanel buttonPanel = new JPanel();
        //Add the button to the panel
        buttonPanel.add(button);
        //Add the panel to the frame
        frame.add(buttonPanel, BorderLayout.SOUTH);
        //Add the roach panel to the frame
        frame.add(roach);
        //Make frame visible
        frame.setVisible(true);
    }