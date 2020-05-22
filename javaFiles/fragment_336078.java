public static void main(String[] args) {
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        set1.add("blue");
        set1.add("red");
        set1.add("yellow");
        set2.add("blue");
        set2.add("red");
        set2.add("orange");

        set1.retainAll(set2);
        System.out.println(set1);
    }