while ((zipEntry = zipStream.getNextEntry()) != null) {
    String name = zipEntry.getName();
    if (!zipEntry.isDirectory()) {
        Scanner scanner = new Scanner(zipStream);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        String YOURSTRING = builder.toString();
    }
}