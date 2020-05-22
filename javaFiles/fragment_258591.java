File file = ...;

    final Map<Pair, Collection<Integer>> lineNumbersByPair = new HashMap<Pair, Collection<Integer>>();

    /*
     * Step 1: Read in the lines, one by one.
     */
    Reader reader = new FileReader(file);
    try {
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            String line;

            int lineNumber = 0;
            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;

                String[] tokens = line.split("\\s+");
                int[] values = new int[tokens.length];

                for (int i = 0; i < tokens.length; i++) {
                    values[i] = Integer.parseInt(tokens[i]);
                }

                for (int i = 0; i < values.length; i++) {
                    for (int j = i + 1; j < values.length; j++) {
                        Pair pair = new Pair(values[i], values[j]);

                        Collection<Integer> lineNumbers;
                        if (lineNumbersByPair.containsKey(pair)) {
                            lineNumbers = lineNumbersByPair.get(pair);
                        } else {
                            lineNumbers = new HashSet<Integer>();
                            lineNumbersByPair.put(pair, lineNumbers);
                        }
                        lineNumbers.add(lineNumber);
                    }
                }
            }
        } finally {
            bufferedReader.close();
        }
    } finally {
        reader.close();
    }

    /*
     * Step 2: Identify the unique pairs. Sort them according to how many lines they appear on (most number of lines to least number of lines).
     */
    List<Pair> pairs = new ArrayList<Pair>(lineNumbersByPair.keySet());
    Collections.sort(
            pairs,
            new Comparator<Pair>() {
                @Override
                public int compare(Pair pair1, Pair pair2) {
                    Integer count1 = lineNumbersByPair.get(pair1).size();
                    Integer count2 = lineNumbersByPair.get(pair2).size();
                    return count1.compareTo(count2);
                }
            }
        );
    Collections.reverse(pairs);

    /*
     * Step 3: Print the pairs and their line numbers.
     */
    for (Pair pair : pairs) {
        Collection<Integer> lineNumbers = lineNumbersByPair.get(pair);
        if (lineNumbers.size() > 1) {
            System.out.println(pair + " appears on the following lines: " + lineNumbers);
        }
    }