public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String word8 = sc.nextLine();
    String word9 = sc.nextLine();
    int index = word8.indexOf(word9);
    sc.close();
    int occurrences = 0;
    while (index != -1) {
        occurrences++;
        word8 = word8.substring(index + 1);
        index = word8.indexOf(word9);
    }
    System.out.println("No of " + word9 + " in the input is : " + occurrences);
}