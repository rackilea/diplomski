String value = textField.getText();
String result;
String str = value.replaceAll("[01]","");

if(str.isEmpty())
    result=Integer.toString(Integer.parseInt(value,2));
else
    result=value;