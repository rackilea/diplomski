public static Result index() {
    initialize();
    (...)
}

public static void initialize() {
    Question question1 = new Question("xyz", "Do Androids dream?", 127, "Marcus");
    Answer answer11 = new Answer("zab", "xyz", "Only of electric sheep!", 70, "Tibor");
    Answer answer12 = new Answer("qwert", "xyz", "No, they dont!", 10, "Sarah");

    List<Answer> answerList1 = new ArrayList<Answer>();
    answerList1.add(answer11);
    answerList1.add(answer12);

    myMap.clear();
    myMap.put(question1, answerList1);
}