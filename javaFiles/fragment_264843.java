b.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        String tfVal = tf.getText();
        String reVal = Szymon.reply(tfVal);
        label.setText(reValue);
    }
});