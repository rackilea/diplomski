if(textViewStatus.getText()!=null){

     if (textViewStatus.getText().toString().equalsIgnoreCase("true"))
     {
        ll.setBackgroundColor(Color.RED);

     }else{
        ll.setBackgroundColor("Different color");
     }
}else{
      ll.setBackgroundColor("Different color");
}