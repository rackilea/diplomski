HashMap<String, Set<Integer>> map = new HashMap<String,Set<Integer>>();
Set<Integer> theValues = new HashSet<Integer>();

public void mapValue(String aString) {
    if(map.containsKey(aString)) {
        System.out.println ("The values of the set is:");
        Set<Integer> set = map.get(aString);
        for (Integer i: set)
            System.out.println(i);
    }
}