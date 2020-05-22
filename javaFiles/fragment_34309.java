File file = new File("file.txt");
Scanner sc = new Scanner(file);
Scanner input = new Scanner(System.in);

System.out.println(/*prompt user for input here*/);

String number = input.next();
String line;
while (sc.hasNextLine()) {
    line = sc.nextLine();
    if (line.contains(number)) {
        System.out.println(line);
        break;
    } else if (!sc.hasNextLine()) {
        System.out.println("Line not found.");
    }
}