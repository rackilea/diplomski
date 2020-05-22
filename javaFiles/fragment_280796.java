public static void main(String[] args) throws IOException {
    HashMap<String, Integer> map1= new HashMap<String, Integer>();
    HashMap<String, Integer> map2= new HashMap<String, Integer>();
    map2.put("foo", 1);
    map2.put("bar", 2);
    map2.put("java", 3);
    map2.put("pojo", 4);
    map2.put("tom", 5);
    map2.put("jerry", 6);

    String[] arr={"foo","java","pojo"};

    for (String arrItem : arr)
    {
        map1.put(arrItem, map2.get(arrItem));
        System.out.println(arrItem);
        System.out.println(map2.get(arrItem));
    }

}