int size = 1024;
String[] strs = new String[size];
Scanner sc = new Scanner(System.in);
for (int i=0; i<size; i++) {
    String input = sc.next();
    if (input.matches("[A-Za-z]")) {
        strs[i] = input;
    } else {
        strs[i] = "";
    }
}
sc.close();