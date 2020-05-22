String input = "v";
String result= "";
for(int i = 0; i < myIndexAlphaMorse.length; i++){
    if(myIndexAlphaMorse[i][0].equals(input)){
        result = myIndexAlphaMorse[i][1];
        break;
   }
}
System.out.println("morse for " + input + " = " + result);