public static void main(String[] args) {
    for(int i = 0; i < 10; i++) {
        Question q1 = new Question();
        q1.askQuestion();
        q1.check();
    }
    System.out.println("Number correct: " + count); //print amount correct, to use this make variable "count" static.
}