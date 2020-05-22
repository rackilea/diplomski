int buttonId = -1;
protected void onCreate(Bundle b){
     //set the layout related stuff first
     Bundle b = getIntent().getExtras();
     if(b!= null && (b.getInt(NEW_BUTTON_KEY, -1)!=-1)){
        buttonPanel = (LinearLayout)findViewById(R.id.LinearButtonPanel);
        for(int i = 0; i< b.getInt(NEW_BUTTON_KEY, -1); i++) 
        Button newButton = new Button(this);
        newButton.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        newButton.setId(i);
        newButton.setText("Button " + i);
        buttonPanel.addView(newButton);

     }
}