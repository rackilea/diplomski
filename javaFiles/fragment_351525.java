@Override
public Object getItem() {
    String objectTxt = myObject[1].toString();
    String feildTxt = textFeild.getText();

    if(objectTxt.equals(feildTxt)){
        return myReturnObject;
    }
    else{
        //Creating and returning custom object with the Feild text
        //and setting the contnent of the text feild in the object
        return new Object[]{"0",textFeild.getText()};
    }
}