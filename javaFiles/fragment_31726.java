if(level == 1  && expmn == 500){
                lvl.setText("2");
                ExpMin.setText("501");
                ExpMax.setText("1000");
                JOptionPane.showMessageDialog(null,"" + "levevlup!" ,"Para Yok",JOptionPane.PLAIN_MESSAGE);
    }// <-- close level1 here because you want to check for a new level afterwards
    else if(level == 2 && expmn == 1000){ //<-- here was your ;, which was wrong
                    lvl.setText("3");
                    ExpMin.setText("1001");
                    ExpMax.setText("2500");

    }
    else{
        JOptionPane.showMessageDialog(null,"" + "leveladssadaup" ,"Para Yok",JOptionPane.PLAIN_MESSAGE);
    }