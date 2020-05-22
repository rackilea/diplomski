String str = "The|value|is|infinite";
String[] temp;

String delimiter = "\\|";

temp = str.split(delimiter);

for(int i = 0; i < temp.length; i++)
   System.out.println(temp[i]);