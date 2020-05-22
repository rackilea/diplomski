public static void main(String[] args) {
    MaxentTagger tagger = new MaxentTagger("files/english-left3words-distsim.tagger");

    //String sample = "This is a sample text";
    String sample = "It works much better with this great example!";
    sample = sample.replaceAll("([^a-zA-Z\\s])", "");
    String[] words = sample.split("\\s+");

    String taggedSample = tagger.tagString(sample);
    String[] taggedWords = taggedSample.split("\\s+");
    System.out.println(tagger.tagString(sample));

    double totalScore = 0;
    SWN3 test = new SWN3();
    System.out.println("-----------");
    for (int i=0; i<taggedWords.length;i++) {
        String tail = taggedWords[i].substring(words[i].length() + 1);
        Double score = null;
        if(tail!=null{
            score = test.extract(words[i], tail);
            System.out.println(taggedWords[i] + "\t" + words[i] + "\t" + tail + "\t" + score);
        }
        if (score == null)
            continue;
        totalScore += score;
    }
    System.out.println("-----------");
    System.out.println(totalScore);
}