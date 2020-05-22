String splitString = "/"; // you can change it to %2F
String s = "http://www.myurl.com/barcodes/images/024543634737.jpg";
int index = s.lastIndexOf(splitString);
String result= null;
if(index > -1){
    result = s.substring(index+splitString.length());
}