public static void main(String[] args) {
    System.out.println("Enter an integer number");
    String sb = new Scanner(System.in).nextLine();

    char[] order = new char[10];
    int[] counts = new int[10];
    for (int i = 0, j = 0; i < sb.length(); i++)
        if (counts[sb.charAt(i) - '0']++ == 0)
            order[j++] = sb.charAt(i); // First occurrence of the digit

    System.out.println("Number\tFrequency");
    for (int i = 0; order[i] != 0; i++)
        System.out.println(order[i] + "\t" + counts[order[i] - '0']);
}