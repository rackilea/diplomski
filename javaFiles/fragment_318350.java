public void actionPerformed(ActionEvent e)
    {
        fontSize = fontSize * -1;
        x = 100;
        y = 100;
        font = new Font("Serif", Font.PLAIN, fontSize); //added line
        repaint();
    }