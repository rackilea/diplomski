// let YamlWriter write its contents to an in-memory buffer
    StringWriter temp = new StringWriter();
    YamlWriter yamlOut = new YamlWriter(temp);
    yamlOut.write(someObject);

    // then dump the in-memory buffer out to a file, manipulating lines that
    // start with a dash
    PrintWriter out = new PrintWriter(new FileWriter(new File("someoutput.dat")));
    LineNumberReader in = new LineNumberReader(new StringReader(temp.toString()));
    String line;
    while ((line = in.readLine()) != null) {
        if (line.startsWith("-")) {
            line = line.substring(1);
        }
        out.println(line);
    }