private void setPacientesInfo(String value){
    testlabel.setVisible(true);
    if(value != null) {
        if (value.indexOf("Sara") != -1){
            testlabel.setText(sara.getName());

        } else if (value.indexOf("Paula") != -1){
            testlabel.setText(paula.getName());

        } else if (value.indexOf("Raul") != -1){
            testlabel.setText(raul.getName());

        }
    } else
        testlabel.setText("");
}