for(int i = 0 ;i < bts1.length ; i++){
        bts1[i] = new JButton(""+i);
        pan3.add(bts1[i]);
        final int j=i; 
        bts1[i].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){                   
                screen.setText(screen.getText()+bts1[j].getText());
            }
        });
    }