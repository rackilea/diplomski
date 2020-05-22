public void paint(Graphics g){
        initButtons(); <------------------- delete
        Graphics2D g2 = (Graphics2D) g;
        if(whatToDraw == 1) {
            g2.setColor(Color.BLUE);
            g2.fillOval(30, 30, 30, 30);
            repaint(); <------------------- delete
        } 
        if(whatToDraw == 2) {
            g2.setColor(Color.GREEN);
            g2.fillRect(30, 30, 30, 30);
            repaint(); <------------------- delete
        }
    }

    @Override
        public void actionPerformed(ActionEvent e) {    
            if(e.getActionCommand().equals(COMMAND_FOR_BUTTON_1)) {//FredK suggested in comments you remove this line.
                whatToDraw = 1;
                pc.repaint()
            }
        }
    });

    button2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            whatToDraw = 2;//removed it would like like this, and do the same. Your solution would be neccessary if 2 buttons shared the same actionListener.
            pc.repaint();
        }
    });