ArrayList<Question> questionForm = new ArrayList<Question>();
    Question q1 = new Question(1, "multiple choice", "java is?", "object oriented | Procedural | Asembly | Machin Level" , 1);
    Question q2 = new Question(2, "multiple choice", "Static block loaded?", "Afer the class | Before the class | never | No such variable in java", 2);
    Question q3 = new Question(3, "multiple choice", "Which is a reserved word in the Java programming language?", "method | native | subclasses | reference", 2);
    questionForm.add(q1); questionForm.add(q2); questionForm.add(q3);

    request.setAttribute( "questionForm", questionForm );