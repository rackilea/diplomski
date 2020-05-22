pushMe.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        int number = rand.nextInt(2);
        textOne.setText(myCoin[number]);
    }
});