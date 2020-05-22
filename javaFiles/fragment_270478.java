public static void main (String [] args) {
    List<String> x = new ArrayList<>();  
    x.add("Go");
    x.add("Go");
    x.add("Go");
    System.out.println(x);
    remove(x, "Go");
    System.out.println(x);
}

public static void remove(List<String> list, String t) {
    list.removeIf(s -> s.equals(t));
}