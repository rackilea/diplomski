button1.addActionListener(new ActionListener() {
    String[] arr={"rock", "paper", "scissors"};
    Random r=new Random();

    public void actionPerformed(ActionEvent evt) {
        int randomNumber=r.nextInt(arr.length);
        tekst1.setText(arr[randomNumber]);
    }
});