public class Main {
    public static void main(String[] args) {
        List<List<String>> source = new ArrayList<List<String>>();

        List<String> first = Arrays.asList("A", "AA", "CB", "10");
        List<String> second = Arrays.asList("A", "AB", "CB", "11");
        List<String> third = Arrays.asList("BA", "BA", "CB", "20");
        List<String> fourth = Arrays.asList("A", "AA", "CB", "12");
        List<String> fifth = Arrays.asList("BA", "BA", "CB", "21");

        source.add(first);
        source.add(second);
        source.add(third);
        source.add(fourth);
        source.add(fifth);

        CustomTree tree = new CustomTree(source, 4);
        System.out.println(tree.get(Arrays.asList("BA", "BA", "CB")));
        System.out.println(tree.get(Arrays.asList("BA", "B", "sf")));
    }
}