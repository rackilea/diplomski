public static void emails() {
        HashSet<String> hs = new HashSet<>();
        FileReader file = null;
        try {
            file = new FileReader(new File("emails.txt"));
        } catch (FileNotFoundException e1) {
            System.err.println("File emails.txt not found!");
            e1.printStackTrace();
        }
        BufferedReader br = new BufferedReader(file);
        String line;
        try {
            while ((line = br.readLine()) != null) {
                fillEmailsHashSet(line, hs);
            }

        } catch (IOException e) {
            System.err.println("Error when reading");
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Unexpected error");
                    e.printStackTrace();
                }
            }
        }
        for (String string : hs) {
            System.out.println(string);
        }
    }