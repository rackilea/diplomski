public String myPreciousString = null;   

public String getInput() { 
   if(myPreciousString == null){
      //show dialog
      myPreciousString  = dialog.getText();
   }
   return myPreciousString ; 
}