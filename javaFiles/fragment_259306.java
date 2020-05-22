ActionListener listener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        x_marks_the_spot();
        JButton sender = (JButton)e.getSource();
        if(sender.getText().equals("X")){
            increase_hit();
        } else{
            increase_miss();
        }
    }
};
for(int i = 0; i<48; ++i){
    button[i] = new JButton("");
    contentPane.add(button[i]);
    button[i].addActionListener(listener);
}