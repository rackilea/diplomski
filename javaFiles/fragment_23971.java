class Test {

    public static void main(String[] args) {

        // Order (could be read from config file)
        String[] order = { "lorem", "ipsum", "dolor", "sit" };


        List<String> someList = new ArrayList<String>();

        // Insert elements in random order.
        someList.add("sit");
        someList.add("ipsum");
        someList.add("sit");
        someList.add("lorem");
        someList.add("dolor");
        someList.add("lorem");
        someList.add("ipsum");
        someList.add("lorem");


        System.out.println(someList);

        Collections.sort(someList, new OrderedComparator(order));

        System.out.println(someList);
    }

}