List<String> theWord = new ArrayList<String>();
String eachWord="";
for(int i=0; i<charz.length; i++){
    eachWord+=charz[i]; // append the char to the String
    if(charz[i]==' ' || i==charz.length-1){
       if(!eachWord.replace(" ", "").equals("")){ // for the followed spaces
          theWord.add(eachWord.replace(" ", "")); // add the word 
       }
       eachWord = ""; // start new string
    }
}
System.out.println(lisrev(theWord));