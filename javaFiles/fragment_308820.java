shuffle(adjectives);
shuffle(nouns);

int aindex = 0;
int nindex = 0;

for (int i = 0; i < 100; ++i) {
    String poem = adjectives[aindex++] + " " + nouns[nindex++];
    System.out.println(poem);

    if (aindex == adjectives.length) {
        aindex = 0;
        shuffle(adjectives);
    }
    if (nindex == nouns.length) {
        nindex = 0;
        shuffle(nouns);
    }
}