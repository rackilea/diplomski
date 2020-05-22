onCreate() {
    ...
    btnHint.setOnClickListener(hintOnClickListener);
    ...
    Flag f = db.getFlag(randomNum); // This is the real question & answer
    List<String> wrongAnswers = new ArrayList<String>(3);
    List<String> allAnswers = new ArrayList<String>(4);

    // Loop 3 times for 3 random wrong answers
    for (int i=0; i<=3; i++) {
       randNum = r.nextInt(200);
       String randWrongAnswer = db.getFlag(randNum).getName().toString();
       if (! wrongAnswers.contains(randWrongAnswer)) {
           wrongAnswers.add(randWrongAnswer);
       }
    }

    allAnswers.add(f.getName().toString());
    allAnswers.addAll(wrongAnswers);
    Collection.shuffle(allAnswers);
    ...
}