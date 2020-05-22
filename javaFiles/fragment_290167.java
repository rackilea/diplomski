static void QuestionsWindow(){
    ProtemInservices.SetActiveQuestions();
    JFrame frame = new JFrame("Quiz for: " + ProtemInservices.testeeName);        
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Vector<JLabel> questions = new Vector<JLabel>();
    Vector<ButtonGroup> questionsGroup = new Vector<ButtonGroup>();
    Vector<JRadioButton> choices = new Vector<JRadioButton>();
    Vector<String> choicesString = new Vector<String>();
    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
    int counter = 0;
    for(int i=0;i<ProtemInservices.ActiveQuestions.size();i++){
        choicesString = new Vector<String>();
        questions.add(new JLabel(ProtemInservices.ActiveQuestions.elementAt(i).GetQuestionText()));
        ProtemInservices.ActiveQuestions.elementAt(i).CopyChoices(choicesString);
        questionsGroup.add(new ButtonGroup());
        frame.add(questions.elementAt(i));
        for(int j=0;j<choicesString.size();j++,counter++){
            choices.add(new JRadioButton(choicesString.elementAt(j)));
            questionsGroup.elementAt(i).add(choices.elementAt(counter));
            frame.add(choices.elementAt(counter));
        }
    }
    frame.setMinimumSize(new Dimension(1280, 1024));

    //Display the window.
    //frame.pack();
    frame.setVisible(true);
}