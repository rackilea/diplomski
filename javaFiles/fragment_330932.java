public class multiConcat {
    public static void main(String[] args) {
        int num = 0;
        String finish = "";
        Scanner reader = new Scanner(System.in);

        System.out.println("Type a word: ");
        String state = reader.next();
        System.out.println("Number of Concatenation: ");
        num = reader.nextInt();

        if (num > 1) {
            for (int i = 0 ; i < num ; i++) {
                finish = finish.concat(state);
            }
        } else {
            finish = finish.concat(state);
        }

        System.out.println(finish);

    }
}