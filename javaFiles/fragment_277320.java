public class SomeClass{
    String name, rank;

    public SomeClass(String name, String rank){
        this.name = name;
        this.rank = rank;
    }
    public static void main(String[] args) {
        SomeClass obj1 = new SomeClass("john", "colonel");
        SomeClass obj2 = new SomeClass("XXX", "major"); 
        SomeClass obj3 = new SomeClass("Roy", "general");
        SomeClass obj4 = new SomeClass("derrick", "no Rank");
        SomeClass obj5 = new SomeClass("john", "something");
        SomeClass obj6 = new SomeClass("Alex", "major");
        List<SomeClass> list = new ArrayList<>();
        list.add(obj1); list.add(obj2); list.add(obj3);
        list.add(obj4); list.add(obj5); list.add(obj6);

        System.out.println(getSortedObjects(list));

    }

    public static Map<String, List<String>> getSortedObjects(List<SomeClass> list){
        Map<String, List<String>> sortedMap = new LinkedHashMap<>();
        // sort the list
        Collections.sort(list, new ObjectComparator());

        for(SomeClass obj : list){
            // for testing sorting before ruining it in a map 
            System.out.println(obj.name + " " + obj.rank);

            List<String> temp;
            if(sortedMap.containsKey(obj.name)){
               temp = sortedMap.get(obj.name);
               temp.add(obj.rank);
               sortedMap.put(obj.name, temp);
            }
            else{
                temp = new ArrayList<>();
                temp.add(obj.rank);
                sortedMap.put(obj.name, temp);
            }
        }

        return sortedMap;
    }
}