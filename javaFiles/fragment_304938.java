public void createButton(int time) {
    Random r = new Random();
    int i1 = r.nextInt(300);
    int i2 = r.nextInt(300);

    Button myButton = new Button(this);
    myButton.setText("Push Me");

    RelativeLayout ll = (RelativeLayout)findViewById(R.id.rela);
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(50, 50);
    lp.setMargins(i1,i2,0,0);
    myButton.setLayoutParams(lp);
    ll.addView(myButton); 

    if(time == 0) 
        return;
    else 
        new MyAsynCTask().execute(time);
}