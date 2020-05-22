jl2.setText("Letters Used:    ");

tf.addActionListener(new ActionListener(){
    @Override public void actionPerformed(ActionEvent e){
        jl2.setText(jl2.getText() + tf.getText());
    }
});