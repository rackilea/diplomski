protected void onStart() {
    super.onStart();
    // dynamic content
    Button b = new Button(this);
    b.setText("test");

    LinearLayout ll = (LinearLayout) findViewById(R.id.linlayout_main);
    System.out.println(ll);
    ll.addView(b);
}