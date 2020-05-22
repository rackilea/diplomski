try (FileReader fr = new FileReader("file.txt"); BufferedReader in = new BufferedReader(fr);) {
    // read all lines from the given file
    String line;
    List<String> lines = new ArrayList<>();
    while ((line = in.readLine()) != null) {
        lines.add(line);
    }

    // process the lines
    for (int i = 0; i < lines.size(); i++) {
        String current = lines.get(i);

        // print the current line to the console output
        System.out.println(current);

        if (current.startsWith("model:")) {
            String args = current.substring("model:".length());
            Pattern pattern = Pattern
                    .compile("\\((-?\\d+\\.\\d+) (-?\\d+\\.\\d+) (-?\\d+\\.\\d+)\\)\\((-?\\d+\\.\\d+) (-?\\d+\\.\\d+) (-?\\d+\\.\\d+)\\) (.+?\\.obj) (.+?\\.png) (.+?\\.jpg) (.+?\\.jpg)");
            Matcher matcher = pattern.matcher(args);

            if (!matcher.matches()) {
                System.out.println("illegal argument format");
                continue;
            }

            double xCoord = Double.parseDouble(matcher.group(1));
            double yCoord = Double.parseDouble(matcher.group(2));
            double zCoord = Double.parseDouble(matcher.group(3));

            double xScale = Double.parseDouble(matcher.group(4));
            double yScale = Double.parseDouble(matcher.group(5));
            double zScale = Double.parseDouble(matcher.group(6));

            String modelFile = matcher.group(7);
            String textureFile = matcher.group(8);
            String diffuseNrmFile = matcher.group(9);
            String diffuseDispFile = matcher.group(10);

            World_Object_1(xCoord, yCoord, zCoord,
                           xScale, yScale, zScale,
                           modelFile, textureFile, diffuseNrmFile, diffuseDispFile);
        }
    }
} catch (IOException e) {
    e.printStackTrace();
}