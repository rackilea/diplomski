List<String> list = new LinkedList<String>(Arrays.asList("A", "B", "C", "D", "E"));
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String next = it.next();
    if(next.equals("D")) {
        list.remove(next);
    }
}