leftArrowBubble.setMaximumSize(new Dimension(400,350));
JLabel tac = new JLabel();
tac.setMaximumSize(new Dimension(350,400));
//tac.setPreferredSize(new Dimension(350,50)); //<----------
System.out.println(str);
tac.setText("<html><body style='width:350px;padding:15px;display:block;'>"
            + str + "</body></html>");