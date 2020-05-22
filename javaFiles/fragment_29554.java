public static void main(String[] args) {
    String input = "123456";
    String minutes = input.substring(0, 2);
    String seconds = input.substring(2, 4);
    String hours = input.substring(4, 6);
    System.out.println("Hours" + hours + "minutes" + minutes + "seconds" + seconds);
}