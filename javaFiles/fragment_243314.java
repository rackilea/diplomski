int length=str.length();
String sentence="";
String word = "";
for(int i=0;i<length;i++) {
    if (str.charAt(i) != ' '){
        word = str.charAt(i) + word;
    } else {
        sentence += word +" ";
        word = "";
    }
}
sentence += word;
System.out.println("the result is: "+sentence);