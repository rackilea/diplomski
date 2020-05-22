private class myActionListener implements ActionListener{


    public void actionPerformed(ActionEvent e) {
        System.out.println(commandLine.getText());
        if (e.getSource() == about) {
            System.out.println("A");
            gp.about();
        }
        else if (e.getSource() == commandLine)
        {
            if (commandLine.getText().contains("penup"))
            {
                gp.penUp();
                commandLine.setText("");
            }
            else if (commandLine.getText().contains("pendown"))
            {
                gp.penDown();
                commandLine.setText("");
            }
            else if (commandLine.getText().contains("turnleft"))
            {
                gp.turnLeft();
                commandLine.setText("");
            }
            else if (commandLine.getText().contains("turnright"))
            {
                gp.turnRight();
                commandLine.setText("");
            }
            else if (commandLine.getText().contains("forward"))
            {
                gp.forward(50);
                commandLine.setText("");
            }
            else if (commandLine.getText().contains("backward"))
            {
                gp.forward(-50);
                commandLine.setText("");
            }
            else if (commandLine.getText().contains("black"))
            {
                gp.setPenColour(Color.black);
                commandLine.setText("");
            }
            else if (commandLine.getText().contains("red"))
            {
                gp.setPenColour(Color.red);
                commandLine.setText("");
            } 
            else if (commandLine.getText().contains("green"))
            {
                gp.setPenColour(Color.green);
                commandLine.setText("");
            } 

        }
    }
}