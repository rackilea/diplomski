double number = 1526374856.03;
String[] array = Double.toString(number).split(".");
String numString = array[0];

String newString = "";
for(int i = 0; i < numString.length() ; i++){
    if((numString.length() - i - 1) % 3 == 0){
        newString += Character.toString(numString.charAt(i)) + ",";
    }else{
        newString += Character.toString(numString.charAt(i));
    }
}
newString += array[1];