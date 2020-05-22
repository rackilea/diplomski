public static void main(String[] args) {

    List<Integer> list = new LinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    for (Iterator<Integer> it = list.iterator(); it.hasNext(); )
        if (it.next().equals(2))
            it.remove();

    System.out.println(list); // prints "[1, 3]"
}