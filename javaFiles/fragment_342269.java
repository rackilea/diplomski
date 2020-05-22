public static void main(String[] args) {
    String art[] = {"beatles","floyd","beatles","dream", "theater","beatles"};
    int plays[]  = {100,       200,    50,      30,       200,      70};

    Map<String, Integer> artistCount = new HashMap<String, Integer>();

    for (int i = 0; i < art.length; i++) {
        if (!artistCount.containsKey(art[i])) {
            artistCount.put(art[i],0);
        }
        artistCount.put(art[i], artistCount.get(art[i]) + plays[i]);
    }

    String artFinal[] = new String[artistCount.size()];
    int playsFinal[] = new int[artistCount.size()];

    int i = 0;
    for (Map.Entry<String,Integer> en:artistCount.entrySet()) {
        artFinal[i] = en.getKey();
        playsFinal[i] = en.getValue();
        i++;
    }
    // to display results
    for (int j = 0; j < artFinal.length; j++) {
        System.out.println(artFinal[j]+": "+playsFinal[j]);
    }
}