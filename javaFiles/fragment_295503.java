public void actionPerformed(ActionEvent e) {

        String text = Input.getText();
        if (text.equals("green"))
        {
            color.setBackground(Color.GREEN);
        }
        else if(text.equals("red"))
        {
            color.setBackground(Color.RED);
        }
        else if(text.equals("yellow"))
        {
            color.setBackground(Color.YELLOW);
        }
        else
        {
            color.setBackground(Color.BLUE);
        }

    }