public class Mayan extends Language {
    private static final String REGION = "Central America";
    private static final String WORD_ORDER = "verb-object-subject";

    public Mayan(String languageName, int speakers) {
        super(languageName, speakers, REGION, WORD_ORDER);
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Fun fact: " + name + " is an ergative language.");
    }
}