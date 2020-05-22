File file = new File("path.txt");

List<String> jobs = new ArrayList<String>();

try (BufferedReader reader = new BufferedReader(new FileReader(file)) {
    String line = "";

    while ((line = reader.readLine()) != null) {
        jobs.add(line);
    }
} catch (IOException e) {
    // handle errors
}

String[] jobArr = new String[jobs.size()];
jobs.toArray(jobArr);