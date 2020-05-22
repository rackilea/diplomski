ActionListener timerListener = new ActionListener(){
    private String text = "";
    private int count = 0;

    public void actionPerformed(ActionEvent e){
        text += // something based on count
        count++;
        textField.setText(text);
        // code to stop timer once count has reached max
    }
});