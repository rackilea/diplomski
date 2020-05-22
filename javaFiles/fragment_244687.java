class Language {
    String name;
    private int numSpeakers;
    private String regionsSpoken;
    private String wordOrder;

    Language(String getName, int getNumSpeakers, String getRegionsSpoken, String getWordOrder) {
        this.name = getName;
        this.numSpeakers = getNumSpeakers;
        this.regionsSpoken = getRegionsSpoken;
        this.wordOrder = getWordOrder;
    }

    void getInfo() {
        System.out.println(name + " is spoken by " + numSpeakers + "  people mainly in " + regionsSpoken);
        System.out.println("The language follows the word order: " + wordOrder);
    }

    public static void main(String[] args) {
        Mayan mayanLanguage = new Mayan("Ki'che'",30000);
        mayanLanguage.getInfo();
    }
}