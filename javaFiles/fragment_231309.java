int result = getTheResult();
String Result = "";
if(result > 0 && result < 1000) Result = "" + result + " Ohms";
else if(result >= 1000 && result < 1000000) Result = "" + (result / 1000) + "K Ohms";
else if (result >= 1000000) Result = "" + (result / 1000000) + "M Ohms";
else Result = "Invalid Value";