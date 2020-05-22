if(str[j].length() == (str[j+1]).length()){ 
if ( str[j].compareTo(str[j+1])>0 ){
String temp = str[j];               
str[j] = str[j+1];
str[j+1] = temp;
   }
}