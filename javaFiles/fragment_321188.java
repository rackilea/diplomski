public static void emails() throws IOException {
    HashSet<String> hs = new HashSet<>();
    FileReader file = null;
    try (BufferedReader br = new BufferedReader(new FileReader(new File("emails.txt")))) {
        String line;
        while ((line = br.readLine()) != null) {
            fillEmailsHashSet(line, hs);
        }
        for (String string : hs) {
            System.out.println(string);
        }
    }
}