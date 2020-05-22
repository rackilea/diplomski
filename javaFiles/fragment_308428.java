static String readCyberText() {
        StringBuilder buffer = new StringBuilder();
        try (final BufferedReader br = Files.newBufferedReader(new File("C:\\projects\\test2201404221017.txt").toPath(),
                StandardCharsets.UTF_8)){
            int ch;
            while ((ch = br.read()) > -1) {
                buffer.append((char)ch);
            }
            return buffer.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }