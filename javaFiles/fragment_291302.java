public final class Question {
    private final String   question;
    private String         answer;
    private CountDownLatch latch = new CountDownLatch(1);

    public Question(String question) {
        this.question = question;
    }
    public String getQuestion() {
        return this.question;
    }
    public String getAnswer() throws InterruptedException {
        this.latch.await();
        return this.answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
        this.latch.countDown();
    }
}