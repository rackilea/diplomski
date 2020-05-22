public static void main(String[] args)
    {
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();

        list1.add("first of first");
        list1.add("second of first");
        list1.add("third of first");

        list2.add("first of second");

        list3.add("first of third");
        list3.add("second of third");

        ArrayList<ArrayList<String>> superList = new ArrayList<ArrayList<String>>();
        superList.add(list1);
        superList.add(list2);
        superList.add(list3);

        String[] output = myMethod(superList);

        for(int i=0; i<output.length; i++)
            System.out.println(output[i]);                  
    }