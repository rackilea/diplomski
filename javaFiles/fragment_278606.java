public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the String Name to encrypt:");
    String inputString = input.nextLine();
    char[] str = inputString.toCharArray();
    replaceString(str);
}

public static void replaceString(char[] str) {
    int length = str.length;
    for(int i = 0; i < length; i++) {
        if(str[i] == 'a') {
            str[i] = 'k';
        } else if(str[i] == 'b') {
            str[i] = 'n';
        }
    }
        System.out.println(Arrays.toString(str));
        System.out.println(String.valueOf(str));
}