public static void main(String[] arg){
    String str= "Hello this a sentence \n this is a new line";
    System.out.println(str);
    String[] xyz = str.split("(?=\n)");
    System.out.println(Arrays.toString(xyz));
}