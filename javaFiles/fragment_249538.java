private final static String testString = "is2 this1 test4 3a"; 

public static void main(String[] args){

String[] splittedString = testString.split(" ");
Map<Integer, String> map  = new TreeMap<Integer, String>();
for(String position: splittedString) {
    map.put(Integer.parseInt(position.replaceAll("[^\\d.]" , "")), position) ;
}