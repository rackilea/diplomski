public static void main(String []args){

    Set<String> file1 = new HashSet<>();
    Set<String> file2 = new HashSet<>();

    file1.add("text");
    file1.add("example");
    file1.add("word");

    file2.add("example");
    file2.add("word");

    Set<String> intersection = new HashSet<>(file1);
    intersection.retainAll(file2);

    System.out.println(intersection);
 }