class FaqEntry{
    String question;
    String answer;
    public FaqEntry(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
enum PopulationWithState {
    MenYoungWorking,
    MenYoungNotWorking;
}