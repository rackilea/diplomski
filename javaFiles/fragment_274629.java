theOkButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent pop_up_that_window = new Intent(MainActivity.this,PopActivity.class);
        pop_up_that_window.putExtra("first", "Velkommen du der!");
        MainActivity.this.startActivityForResult(pop_up_that_window, 1);

    }
});