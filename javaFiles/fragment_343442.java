String line = "";
String region = "", name = "";
BufferedReader file = new BufferedReader(new FileReader("Stores.txt"));
line = file.readLine();
while (line != null) {
    if (!line.isEmpty()) {
        region = line.substring(0, 10);
        name = line.substring(10);
        System.out.println("" + region + name);
    }
    line = file.readLine();
}
file.close();