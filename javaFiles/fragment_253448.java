yourButton.setOnClickListener(new View.OnClickListener() {
    int count = 0;
    public void onClick(View v) {
        if (count++ < 10) {
            showItem();
        }
    }
});