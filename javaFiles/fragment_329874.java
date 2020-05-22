Scanner input = new Scanner(myFile).useDelimiter(",");

while (input.hasNextLine()) {
    String[] line = input.nextLine().split(",");
    String firstName = line[0];
    String lastName = line[1];
    int score = Integer.parseInt(line[2]);
    System.out.println(firstName + " " + lastName + " " + score);
}