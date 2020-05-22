char[] charz = word.toCharArray();
String wordReversed = "";
for (int i=charz.length-1; i>=0; i--){
      wordReversed+= charz[i];
}
System.out.println(wordReversed);