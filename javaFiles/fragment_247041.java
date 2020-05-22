System.out.println("Input a number");
String line = "";
while (sc.hasNextLine() && !(line = sc.nextLine()).equals("")) {
    try {
        int val = Integer.parseInt(line);
        values.add(val);
    } catch (NumberFormatException e) {
        break;
    }

    System.out.println("Input a number");
}