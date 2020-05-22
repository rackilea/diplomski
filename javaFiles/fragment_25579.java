// Do the long press stuff
menu_home_button.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(getApplicationContext(), "Long Press works...", Toast.LENGTH_SHORT).show();
        // Do whatever you want on the longclick
    }
});