String key = "Security".toLowerCase();
    String alphabet =
            // Split the key into characters.
            Arrays.stream(key.split(""))
            // Sort it.
            .sorted()
            // Put it back together into a String again.
            .collect(Collectors.joining());
    for (int i = 0; i < key.length(); i++) {
        System.out.print(alphabet.indexOf(key.charAt(i)) + 1 + " ");
    }