/**
 * Constructor
 * @param stringToMap
 */
public Q1_JavaApplication1(String stringToMap){

    mapStringToNumbers(stringToMap);
}

/**
 * 
 * @param stringToMap
 */
private int[] mapStringToNumbers(String stringToMap) {
    Map<Character, Integer> map;
    String str = stringToMap;
    str = str.replaceAll(" ", "");//remove empty strings
    char[]ca = str.trim().toCharArray();//initiate char array
    int[] intArray = new int[ca.length];//initiate integer array

    map = new HashMap<>();  
    map.put('a', 1);
    map.put('i', 1);
    map.put('j', 1);
    map.put('q', 1);
    map.put('y', 1);

    map.put('b', 2);
    map.put('k', 2);
    map.put('r', 2);

    map.put('c', 3);
    map.put('g', 3);
    map.put('l', 3);
    map.put('s', 3);

    map.put('d', 4);
    map.put('m', 4);
    map.put('t', 4);

    map.put('e', 5);
    map.put('h', 5);
    map.put('n', 5);
    map.put('x', 5);

    map.put('u', 6);
    map.put('v', 6);
    map.put('w', 6);

    map.put('o', 7);
    map.put('z', 6);

    map.put('f', 8);
    map.put('p', 8);

    System.out.println("output:");

    for(int i = 0; i < ca.length; i ++){//populate and print integer array content
        intArray[i] = map.get(ca[i]);
        System.out.print(intArray[i] + " ");
    }
    return intArray;// return your array
}

/**
 * 
 * @param args
 */
public static void main(String[] args) {
    String stringToMap = "good morning";//Get your input from args[] OR from keyboard/system.in - for example Scanner OR hard code in main() method (like here)..
    new Q1_JavaApplication1(stringToMap);
}