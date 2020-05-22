final String NAME = "name";
final String CODE = "code";

BufferedReader br = new BufferedReader(new FileReader(file));
PrintWriter out = new PrintWriter(new FileWriter("log.txt", true));

while ((line = br.readLine()) != null) {
    String[] splits = line.split("=");
    String key = splits[0];
    String value = splits[1];

    if (key.equals(NAME) || key.equals(CODE)) {
        out.println(value);
    }
}

out.close();