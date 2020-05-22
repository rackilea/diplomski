JButton button1 = new JButton("Button 1");
    InitialScreen panel = new InitialScreen(); // I am assuming this is a JPanel
    button1.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            // TODO add your logic
        }
    });
    panel.add(button);
    tela.add(panel);