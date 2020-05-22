public static int max(String s){
    s=s.replaceAll("\\D","");
    int x = s.length();  
    int y = Character.getNumericValue(s.charAt(0));

    for (int i=1; i < x; i++){  
         if (Character.getNumericValue(s.charAt(i)) > y){
            y=Character.getNumericValue(s.charAt(i));
         }
    }    
    return y;   
}