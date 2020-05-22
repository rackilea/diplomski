String com=textview.getText();
   String liks = "likes";
   String str_new   ="";
  if (com.toLowerCase().indexOf(liks) != -1) {
     str_new=com.replaceAll(" Likes","");
   }else{
     str_new=com.replaceAll(" like","");
   }