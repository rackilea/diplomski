public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader("")); FileWriter writer = new FileWriter("");) {
        String line;

        while ((line = reader.readLine()) != null) {
            writer.write("www." + line + ".com");
            writer.write("\n");
        }
    }
}