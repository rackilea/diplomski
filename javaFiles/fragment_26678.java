boolean foundLeDigit = false;
for (int i = 0; i < data.length; i++) {

     if (data[i].equals("Digit") == false && data[i].equals(".") == false  {
        //we found something other than a Digit or . it's not a float
       return false;
     }
    if(data[i].equals(".")) { 
     if(foundLeDigit) { return false; //as we found 2 "." }
    foundLeDigit = true
    }


}
return foundLeDigit;