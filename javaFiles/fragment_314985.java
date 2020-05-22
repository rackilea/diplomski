Path originalPath = Paths.get("... .xml");
try (BufferedReader in = Files.newBufferedReader(originalPath, StandardCharsets.UTF_8)) {
    String line = in.readLine(); // Skip header line(s)

    line = in.readLine();
    for (int fileno; line != null && !line.contains("</EmployeeDetails>"); ++fileno) {
        Path partPath = Paths.get("...-" + fileno + ".xml");
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(partPath,
                StandardCharsets.UTF_8))) {
            int counter = 0;
            out.println("<EmployeeDetails>"); // Write header.
            do {
                out.println(line);
                if (line.contains("</Employee>") {
                    ++counter;
                }
                line = in.readLine();
            } while (line != null && !line.contains("</EmployeeDetails>")
                    && counter < 1000);
            out.println("</EmployeeDetails>");
        }
    }
}