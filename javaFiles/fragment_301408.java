Question question = questions.get(new Random().nextInt(questions.size()));

System.out.println(question.getQuestion());

Scanner scanner = new Scanner(System.in);

for (int i = 0; i < 3; i++) {
    String answer = scanner.nextLine();

    boolean correct = false;
    for (Answer a : question.getAnswers()) {
        if (a.getAnswer().toLowerCase().contains(answer)) {
            System.out.println(a.getAnswer() + " " + a.getPoints());
            correct = true;
            break;
        }
    }
    if (!correct) {
        System.out.println("WRONG!");
    }
}