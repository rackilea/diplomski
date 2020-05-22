Path tmp = Files.createTempFile(prefix, suffix, attrs);
    try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
        String line;
        for (int i = 1; (line = br.readLine()) != null; i++) {
            if (i == 5) {
                line = replaceAge(line, newAge);
            }
            bw.write(line);
            bw.newLine();
        }
    }
    Files.move(tmp, path, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);