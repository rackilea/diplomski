clickerButton.setOnClickListener(new View.OnClickListener() {
    public void onClick() {
        clickerNumber = clickerNumber + 1;
        clickerText.setText(Integer.toString(clickerNumber));
    }
});