List<String> lines11;
Set<String> dups;
try (BufferedReader reader11 = new BufferedReader(new FileReader("test.txt"))) {
    lines11 = new ArrayList<>();
    dups = new HashSet<>();
    String line11;
    while ((line11 = reader11.readLine()) != null) {
        String first = line11.split(":")[0]; // assuming your separator is :
        if (!dups.contains(first)) {
            lines11.add(line11);
            dups.add(first);
        }
    }
}
try (BufferedWriter writer11 = new BufferedWriter(new FileWriter("test.txt"))) {
    for (String unique : lines11) {
        writer11.write(unique);
        writer11.newLine();
    }
}