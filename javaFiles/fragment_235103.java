public static void main(String []args){
     String a = "This is a life and our life will be full of fun just like the Benn Steller's Secret life of Walter Mitty Mitty";
     System.out.println(removeOneDuplicate(a));
}

public static String removeOneWord(String str, String word){
    int value = str.indexOf(word);
    String result = str.substring(0, value);
    result += str.substring( value+word.length(), str.length());
    return result;
}

public static String removeOneDuplicate(String a){
    String [] tmp = a.split(" ");
     Map<String, Integer> map = new HashMap<String, Integer>();
     for(String s: tmp){
         if( map.containsKey(s)){
            int value = map.get(s); 
            if(value == 1)
                a = removeOneWord(a, s);
             map.put(s, value + 1);
         }
         else
             map.put(s, 1);
     }
     return a;
}