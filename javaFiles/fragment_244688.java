class Mayan extends Language {
    private static final String REGION = "Central America";
    private static final String WORD_ORDER = "verb-object-subject";

    Mayan(String languageName, int speakers) {
        super(languageName, speakers, REGION, WORD_ORDER);
    }

    @Override
    void getInfo() {
        super.getInfo();
        System.out.println("Fun fact: " + name + " is an ergative language.");
    }
}