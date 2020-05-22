public static void main(String[] args) {

    List<ComplexObject> complexObjectList = new ArrayList<ComplexObject>();

    //add elements to the list
    complexObjectList.add(new ComplexObject("testval","testval",100.00d));
    complexObjectList.add(new ComplexObject("anotherval","anotherval",50.00d));

    //sort the list in descending order based on the value attribute of complexObject
    Collections.sort(complexObjectList, new Comparator<ComplexObject>() {
            public int compare(ComplexObject obj1, ComplexObject obj2) {
                return obj2.getValue().compareTo(obj1.getValue()); //compares 2 Double values, -1 if less , 0 if equal, 1 if greater
            }
        });

    //print objects from sorted list
    for(ComplexObject co : complexObjectList){
        System.out.println(co.getDescription1()+" "+co.getDescription2()+" "+co.getValue());
    }
}