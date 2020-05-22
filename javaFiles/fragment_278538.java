public static void main(String... args) throws Exception {
    String ipAdd = "[\"2.2.2.2\",\"1.1.1.1\",\"6.6.6.6\",\"4.4.4.4\"]";
    List<String> list = Arrays.asList(ipAdd.replaceAll("\\[|\\]", "").split(","));
    for (String s : list){
        System.out.println(s);
    }

}