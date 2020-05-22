public static void printingCharacters(Map<Character, Integer> m, Map <Character, Integer> m1) {    
    Iterator<Map.Entry<Character, Integer>> it = m.entrySet().iterator();
    Iterator<Map.Entry<Character, Integer>> it1 = m1.entrySet().iterator();

    while(it.hasNext() && it1.hasNext()) {
        printEntries(it.next(), it1.next());
    }
}

public static void printEntries(Map.Entry<Character, Integer> e, Map.Entry<Character, Integer> e1) {
    System.out.printf("Letter: %c :  Time occurs: %d -  %.2f %%\t\t\t Letter: %c :  Time occurs: %d -  %.2f %%\n ", e.getKey(),
            e.getValue(), percentageOfOccurrence(e.getValue()), e1.getKey(), e1.getValue(), percentageOfOccurrence(e1.getValue()));
    System.out.println("-----------------------------------------------|  \t|-----------------------------------------------------|");
}