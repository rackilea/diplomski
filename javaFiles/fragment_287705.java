public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String a = "I like watching movies";
        MaxentTagger tagger =  new MaxentTagger("D:\\left3words-wsj-0-18.tagger");
        String tagged = tagger.tagString(a);
        System.out.println(tagged);
        String[] splitStrings = tagged.split(" ");
        String[] tagsOnly = new String[splitStrings.length];
        for (int i = 0; i < tagsOnly.length; i++) {
            tagsOnly[i] = splitStrings[i].split("/")[1];
        }
        System.out.println(Arrays.toString(tagsOnly));
    }
}