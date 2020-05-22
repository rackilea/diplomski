String user_Id = null; //Create an instance of String variable before initializing (Optional)

if (item.isFormField()) {
    if(item.getFieldName().contentEquals("name")){  //Check if the item in the loop is the user_id
         user_id = item.getString();                //If yes store the value
    }
} else { //continue with your current code