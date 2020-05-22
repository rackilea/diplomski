Map<String, Integer> countByWords = new HashMap<String, Integer>();
    Scanner s = new Scanner(new File("your_file_path"));
    while (s.hasNext()) {
        String next = s.next();
        Integer count = countByWords.get(next);
        if (count != null) {
            countByWords.put(next, count + 1);
        } else {
            countByWords.put(next, 1);
        }
    }
    s.close();