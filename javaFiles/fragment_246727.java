public void CreateTabs() {
    JPanel question = null;
    JLabel lbQuestion = null;
    JButton ansA = null;
    JButton ansB = null;
    JButton ansC = null;
    for (int i=0;i<probList.length;i++) {
        question = new JPanel();
        lbQuestion = new JLabel(probList[i].getQuestion());
        question.add(lbQuestion);
        ansA = new JButton(probList[i].getAnsA());
        ansB = new JButton(probList[i].getAnsB());
        ansC = new JButton(probList[i].getAnsC());
        question.add(ansA);
        question.add(ansB);
        question.add(ansC);
        quiz.addTab("Question " + (i+1), question); 
    }
}