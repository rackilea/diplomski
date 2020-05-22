public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int n = keyboard.nextInt();
    keyboard.nextLine();
    char[][] mazeValue = new char[n][n];
    for (int i = 0; i < n; i++) {
        String values = keyboard.nextLine();
        for (int j = 0; j < values.length(); j++) mazeValue[i][j] = values.charAt(j);
    }


}