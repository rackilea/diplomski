String[] input = L1x.split(" "); 

// remove the 't'
String tNum = input[0].substring(0, input[0].length() - 1);
int t = Integer.parseInt(tNum); 
int constant = Integer.parseInt(input[2]); 
String operator = input[1];

if (operator == "-")
    constant *= -1;