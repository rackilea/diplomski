btn = new Button(this);
 btn.setText("Hello Button");
 RelativeLayout.LayoutParams paramsd = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONT ENT,LayoutParams.WRAP_CONTENT);
 paramsd.height = 60;
 paramsd.width = 60;
 btn.setLayoutParams(paramsd);
 addContentView(btn,paramsd);