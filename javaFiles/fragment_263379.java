public static void main(String[] args)
{
    ListHolder<Object> listHolder = new ListHolder<Object>();

    listHolder.list.add(new ArrayList<Object>());
    listHolder.list.get(0).add("hello");
    listHolder.list.get(0).add("world");

    listHolder.list.add(new ArrayList<Object>());
    listHolder.list.get(1).add("a");
    listHolder.list.get(1).add("b");
    listHolder.list.get(1).add("c");

    System.out.println("Size: " + listHolder.size());
    System.out.println("listHolder[0]: " + listHolder.get(0)); // "hello"
    System.out.println("listHolder[1]: " + listHolder.get(1)); // "world"
    System.out.println("listHolder[2]: " + listHolder.get(2)); // "a"
    System.out.println("listHolder[3]: " + listHolder.get(3)); // "b"
    System.out.println("listHolder[4]: " + listHolder.get(4)); // "c"
    System.out.println("listHolder[5]: " + listHolder.get(5)); // "null"
}