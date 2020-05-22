public static void main(String[] args) throws Exception {
    BlockingQueue<Question> queue = new LinkedBlockingQueue<>();
    Worker w1 = new Worker(queue, 3, "Can you play poker?",
                                     "Can you juggle?",
                                     "Can you summersault?");
    Worker w2 = new Worker(queue, 4, "How old are you?",
                                     "How tall are you?");
    new Thread(w1).start();
    new Thread(w2).start();
    Scanner in = new Scanner(System.in); 
    for (int i = 0; i < 5; i++) {
        Question q = queue.take();
        System.out.println(q.getQuestion());
        String answer = in.nextLine();
        q.setAnswer(answer);
    }
}