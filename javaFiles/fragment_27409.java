try {
    Scanner sc = new Scanner(f);

    while (sc.hasNext()) {
        SentencesToUse.inputtedSentences.ass(sc.nextLine());
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}