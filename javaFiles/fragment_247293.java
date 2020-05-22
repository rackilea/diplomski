private void addNumbers(){ // Numbers is set with random position
    for (int i = 1; i < 3; i++) {
        Button btn1 = new Button(this);
        Button btn2 = new Button(this);
        btn1.setOnClickListener(listener1);
        btn2.setOnClickListener(listener2); // here using different listener
        btn1.setText("" + i);
        btn2.setText("" + i); //same text

        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(50, 50);
        int leftMargin = new Random().nextInt(widthScreen/2 - btnSize ); 
        int topMargin = new Random().nextInt(heightScreen - btnSize);    
        lp.leftMargin = leftMargin;
        lp.topMargin = topMargin;

        btn1.setLayoutParams(lp);
        btn2.setLayoutParams(lp); //same lp 

        framelayout1.addView(btn1);
        framelayout2.addView(btn2);
    }
}