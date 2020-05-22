public MyFrame1() {
   //...
   JTextField dateField = new JTextField();
   //...
   dateField.addClickListener(new EventListener(){
        new MyFrame2(dateField);
   });
}


public MyFrame2(dateField) {
    //...
    // When updating :
         dateField.setText(text);
}