int counter=0;
String[][] array = something;
for(String[] subArray : array)
    for(String string : subArray)
        if(string.toLowerCase().equals("m"))
            counter++;
//Counter has the value of the amount of 'm's in the array