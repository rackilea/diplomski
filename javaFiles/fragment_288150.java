String line = "";
int i = 0;
try (BufferedReader fileReader = new BufferedReader(new FileReader(""))) {
    while ((line = fileReader.readLine()) != null) {
        lineArray[i++] = line;
        String[] tokens = line.split(DELIMITER);
        for (String token : tokens) {
            totalData.add(token);
            if (!artists.contains(token)) {
                artists.add(token);
            }
        }
    }
}