class YourListener implements View.OnClickListener {

    private int correctButtonId;

    public YourListener(int correctButtonId) {
        this.correctButtonId = correctButtonId;
    }

   @Override
    public void onClick(View v) {
        if (v.getId() == correctButtonId) {
            // do stuff
        } else {
            // do other stuff
        }
    }
}