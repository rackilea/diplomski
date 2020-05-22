public static void main(String[] args) {
    List<String> lst = new ArrayList<>();
    String[] strLst = { "1,", "2", "3" };
    lst.addAll(Arrays.asList(strLst));
    System.out.println(lst);
}