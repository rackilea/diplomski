String command = "";
while (sc.hasNextLine()) {
    String line = sc.nextLine().trim();
    //ignore empty lines
    if (!line.isEmpty()) {
        if (line.startsWith("INSERT ")) {
            command = line;
        } else {
            //lets change `),` to `);`
            String values = line.replaceAll(",$", ";");
            inserts.add(command + " " + values);
        }
    }
}