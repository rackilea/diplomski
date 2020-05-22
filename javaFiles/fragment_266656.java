String everything;
    ArrayList<String> list = new ArrayList<String>();

    try(BufferedReader br = new BufferedReader(new FileReader("lol/new.txt"))) {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine(); // Read first line

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            list.add(line); // Line order has changed!
            line = br.readLine(); // Read next line
        }
        everything = sb.toString(); // maybe I'll need this :D 

    }