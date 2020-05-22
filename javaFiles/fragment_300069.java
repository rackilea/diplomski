Path p = Paths.get("src", "inware", "users.txt");
    try {
        Path tempFile = Files.createTempFile(p.getParent(), "usersTemp", ".txt");
        try (BufferedReader in = Files.newBufferedReader(p);
             PrintWriter out = new PrintWriter(Files.newBufferedWriter(tempFile))) {
            for (String line; (line = in.readLine()) != null;) {
                line = line.trim();
                if (!line.isEmpty()) {
                    out.println(line);
                }
            }
        }
        Files.copy(tempFile, p, StandardCopyOption.REPLACE_EXISTING);
        Files.delete(tempFile);

    } catch (IOException ex) {
        Logger.getLogger(ManageStudentController.class.getName()).log(Level.SEVERE, null, ex);
    }