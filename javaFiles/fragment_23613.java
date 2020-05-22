public void run() {
    /* Create an Intent that will start the Menu-Activity. */
    Intent mainIntent = new Intent(getApplicationContext(),Menu.class);
    startActivity(mainIntent);
    finish();
}