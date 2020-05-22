if (type == TYPE.CHECKBOXES){
     LinearLayout myPanel = new LinearLayout(this);
     for (int i = 0; i < n ; i++){
          CheckBox chk=new CheckBox(this);  
          chk.setText("Hello");
          myPanel.addView(chk); 
     }
     myRootPanel.addView(myPanel);
}