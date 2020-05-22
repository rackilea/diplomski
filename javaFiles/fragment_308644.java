public static void main(String[] args) {
    String s = "1 Hello 1 World 2 3 Hello 7";
    Scanner sc = new Scanner(s);

    while (sc.hasNext()) {
        if (!sc.hasNextInt()) {
            sc.next();
        } else {
            System.out.println(sc.nextInt());
        }
    }
}