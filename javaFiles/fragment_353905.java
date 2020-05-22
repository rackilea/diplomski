public class Parrot implements Pet {
    private String phrase = "Pieces of eight!";

    @Override
    public String talk() {
        return phrase;
    }

    public void teach(String phrase) {
        this.phrase = phrase;
    }
}