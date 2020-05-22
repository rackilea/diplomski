public static String addPounds(String s, int x){
    String a = "";

    //starting from 1 so i can do mod division easily
    for(int i = 1; i <= s.length(); i++){

        //check if next # has to be placed at the end
        if(i + 1 > s.length() && (i + 1) % x == 0){
            a += "#";

        //check if next # has to be placed somewhere inside the string
        }else if(i % x == 0){
            a += s.charAt(i - 1);
            a += "#";

        //oherwise just add the char at i-1
        }else {
            a += s.charAt(i - 1 );

        }
    }
    return a;
}