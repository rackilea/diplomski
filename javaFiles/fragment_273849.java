public static void main(String[] args) throws NumberFormatException,
        IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(
            System.in));
    int count = 0;
    int width = 0;
    int height = 0;
    String number;
    while (count < 2) { // Just 2 inputs
        number = reader.readLine();
        if (count == 0) {
            width = Integer.parseInt(number);
            count++;
        } else if (count == 1) {
            height = Integer.parseInt(number);
            count++;
        }
        else // If count >= 2, exits while loop
            break;
    }
    System.out.println(width * height);
}