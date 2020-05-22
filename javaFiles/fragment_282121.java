public static void main(String[] args){

    UtilClass test = new UtilClass();

    for(int i = 0; i < 10; i++){
        test.addMapEntry("foo", "foo"+i);
        test.addMapEntry("bar", "bar"+i);
    }

    for(Object key : test.getMap().keySet()){
        System.out.println("Printing map");
        System.out.println(key + " = " + test.getMap().get(key).toString());
    }

    Object[][] objects = test.getMapAs2dArray();

    System.out.println("printing 2d Array");
    System.out.println(Arrays.deepToString(objects));

    System.out.print("Done");
}