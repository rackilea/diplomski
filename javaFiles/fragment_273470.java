String command = "";
while (sc.hasNextLine()) {
    String line = sc.nextLine().trim();
    if (line.isEmpty() || command.isEmpty()) {
        command = line;
    } else {
        String values = line.replaceAll(",$", ";");//replace `,` at the end with ;
        inserts.add(command + " " + values);
    }
}