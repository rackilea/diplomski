Double newNumber = 0;
if(number.charAt(i).isDigit()){
     //parse numeber here using WarrenFaiths method and place the int or float or double 
     newNumber = Double.valueOf(number);
}else{
    Boolean negative = false;

    if(number.startsWith("-") || number.endsWith("-")){
         number = number.replace("-", "");
         negative = true;
    }
    if(number.startsWith("(") || number.endsWith(")"){
        number = number.replace("(", "");
        number = number.replace(")", "");
    }

    //parse numeber here using WarrenFaiths method and place the float or double 
    newNumber = Double.valueOf(number);

    if(negative){
      newNumber = newNumber * -1;
    }
}