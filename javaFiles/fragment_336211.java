public Question[] getQuestions ()
{
    String[] options1 = {"ABCD", "EFGH", "IJKL", "MNOP"};
    String[] options2 = {"Bangalore", "Delhi", "Mumbai", "Pune"};
    String[] options3 = {"Business", "Work", "Nothing", "Study"};

    Question[] ques = new Question[3];

    ques[0] = new Question("What is your name?", 2, options1);

    ques[1] = new Question("Where are you from?", 3, options2);

    ques[2] = new Question("What do you do?", 4, options3);

    return ques;
}