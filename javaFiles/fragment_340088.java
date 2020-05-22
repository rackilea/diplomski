public static void main(String[] args) {
   String sentence = "Cat Is Running";
   reverse(sentence);
 }

public static void reverse(String str) {
   int spaceIndex = str.lastIndexOf(" ");
   if(spaceIndex == -1){
     System.out.print(str);
     return;
   }
   System.out.print(str.substring(spaceIndex+1) + " ");
   reverse(str.substring(0,spaceIndex));
}