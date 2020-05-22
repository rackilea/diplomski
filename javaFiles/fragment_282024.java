ArrayList<String>  hasil = new ArrayList<String>();
    hasil.add("saya makan saya");
    hasil.add("makan kamu saya");
    hasil.add("kamu dimana");

    Map<String, Integer> tokenCount = new HashMap<>();

    for (String phrase : hasil) {
        String[] tokens = phrase.split(" ");
        for (String token : tokens) {
            Integer count = tokenCount.get(token);
            if (count == null)
                count = 0; // first time this token was found

            tokenCount.put(token, count+1);
        }
    }