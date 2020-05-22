private void xoPerformed(java.awt.event.ActionEvent evt){
        JButton btn = (JButton) evt.getSource();
        if(x==0){
            btn.setText("O");
            x=1;
            jLabel1.setText(p2+"'s Turn");
        }
        else{
            btn.setText("X");
            x=0;
            jLabel1.setText(p1+"'s Turn");
        }
        btn.setEnabled(false);
        findWinner();
    }