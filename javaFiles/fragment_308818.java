List<String> adjectives = new ArrayList<>(Arrays.asList(adjectivesArr));
List<String> nouns = new ArrayList<>(Arrays.asList(nounsArr));
Collections.shuffle(adjectives);
Collections.shuffle(nouns);

int aindex = 0;
int nindex = 0;

for (int i = 0; i < 100; ++i) {
    String poem = adjectives.get(aindex++) + " " + nouns.get(nindex++);
    System.out.println(poem);

    if (aindex == adjectives.size()) {
        aindex = 0;
        Collections.shuffle(adjectives);
    }
    if (nindex == nouns.size()) {
        nindex = 0;
        Collections.shuffle(nouns);
    }
}