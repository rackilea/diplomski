public void run() {
    /* Create an Intent that will start the Menu-Activity. */
    Intent mainIntent = new Intent(Splash.this,Menu.class);
    Splash.this.startActivity(mainIntent);
    Splash.this.finish();
}