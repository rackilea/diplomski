public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your name: ");
    String name = sc.nextLine();
    int enteredNamesLength = name.length();

    for (int i = 0; i <= enteredNamesLength; i++) {
            System.out.println(name.substring(0, (int) i));
    }

    for(int i = 1;i <= enteredNamesLength; i++ ) {
            for(int j = 0;j < i; j++) {
                    System.out.print(" ");
            }
            System.out.println(name.substring(i, enteredNamesLength));
    }
}