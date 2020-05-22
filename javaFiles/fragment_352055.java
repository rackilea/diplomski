try (Scanner s = new Scanner(file).useDelimiter("\\s*-\\s*")) {

        while (s.hasNextLine()) {
            String dictionary = s.nextLine();
            System.out.println(dictionary);
            if (sig.compareToIgnoreCase(wordToSignature(dictionary)) == 0) {
                System.out.println("match");
                break;
            }
        }
        Set<String> set = new HashSet<>();
        set.add(dictionary);
        return set;
    }