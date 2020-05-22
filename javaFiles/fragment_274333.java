Dialog d = new Dialog(MainActivity.this);
    d.requestWindowFeature(Window.FEATURE_NO_TITLE);
    d.setContentView(R.layout.dialog);
    Button button = (Button) d.findViewById(R.id.share_button);
    Button button2 = (Button) d.findViewById(R.id.continue_button)
    d.show();