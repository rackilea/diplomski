LinearLayout comp = (LinearLayout) findViewById(R.id.main);
if (alt_Layout) {
    LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
inflater.inflate(R.id.main, comp, true);
} else {
    LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
inflater.inflate(R.layout.buttons, comp, true);
}