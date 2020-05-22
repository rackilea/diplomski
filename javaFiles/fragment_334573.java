public static void main(String[] args) {
    System.out.println("enter the lines");
    Scanner s = new Scanner(System.in);
    ArrayList<String> result = new ArrayList<String>();
    String line = "";
    while ((line = s.nextLine()) != null) {
        if (line.isEmpty()) break;
        result.add(line);
    }
    for (String ss : result) {
        System.out.println(ss);
    }
}