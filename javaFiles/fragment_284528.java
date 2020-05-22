public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int hours = in.nextInt();
    int minutes = in.nextInt();

    minutes = minutes + 15;
    hours += minutes / 60;
    minutes = minutes % 60;

    System.out.printf("%d:%02d", hours, minutes);
}