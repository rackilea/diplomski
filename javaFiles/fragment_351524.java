@Override
 public void setItem(Object anObject) {

    if(anObject != null){
        myObject = (Object[])anObject;
        myReturnObject = anObject;
        //I can now set whatever i want in the text feild            
        textFeild.setText(myObject[1].toString());//<--
     }
     else{ 
       myReturnObject = anObject;
     }
}