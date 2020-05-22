public void itemStateChanged(ItemEvent ie) {
            if(ViewSpace.getState()){
                tx.setText(previous.replace(" ","."));
        }
            else
                tx.setText(str);
        }