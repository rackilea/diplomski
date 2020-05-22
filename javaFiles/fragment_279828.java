List<String> ipList = new ArrayList<>();
try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), theAppropriateEncoding))) {
    String line;
    while ((line = reader.readLine()) != null) {
        ipList.add(line);
    }
}