public class Perm {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        Collection<List<String>> permutations = Collections2.permutations(list);
        for (List<String> strings : permutations) {
            String s = strings.toString();
            System.out.println(s);
        }
    }
}