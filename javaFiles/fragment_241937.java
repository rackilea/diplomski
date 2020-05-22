public static void main(String[] args) {
    try {
        String searchText = "1";
        Path p = Paths.get(".", "users.txt");
        Path tempFile = Files.createTempFile(p.getParent(), "usersTemp", ".txt");
        try (BufferedReader reader = Files.newBufferedReader(p);
                BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            String line;

            // copy everything until the id is found
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("[,]");
                if (searchText.equals(fields[0])) {
                    for (int i = 0; i < fields.length; ++i) {
                        System.out.println(i + ": " + fields[i]);
                    }
                    fields[12] = "12";
                    fields[13] = "21/10/18";
                    fields[14] = "2";
                }
                writer.write(String.join(",", fields));
                writer.newLine();
            }
        }

        // copy new file & delete temporary file
        Files.copy(tempFile, p, StandardCopyOption.REPLACE_EXISTING);
        Files.delete(tempFile);
    } catch (IOException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
}