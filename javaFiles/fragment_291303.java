public final class Worker implements Runnable {
    private final Queue<Question> queue;
    private final int             delayInSeconds;
    private final String[]        questions;

    public Worker(Queue<Question> queue, int delayInSeconds, String... questions) {
        this.queue = queue;
        this.delayInSeconds = delayInSeconds;
        this.questions = questions;
    }
    @Override
    public void run() {
        List<String> answers = new ArrayList<>();
        try {
            for (String question : this.questions) {
                Thread.sleep(this.delayInSeconds * 1000L);
                Question q = new Question(question);
                this.queue.add(q);
                String answer = q.getAnswer();
                answers.add(answer);
            }
        } catch (InterruptedException unused) {
            System.out.println("Interrupted");
        }
        System.out.println(answers);
    }
}