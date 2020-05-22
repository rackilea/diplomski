Float[] numbers = new Float[4];
Scanner scan = new Scanner(System.in);
String fileName = scan.next();
scan.close();
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader(fileName));
    String input = null;

    while ((input = reader.readLine()) != null) {
        String nums[] = input.trim().split("\\s+");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Float.parseFloat(nums[i]);
        }
        break;
    }
    System.out.println(Arrays.toString(numbers));
} catch (NumberFormatException | IOException e) {
    e.printStackTrace();
}