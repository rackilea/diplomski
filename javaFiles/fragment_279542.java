HashMap<String, String[]> responses = new HashMap<String, String[]>();
    String[] temp0 = { "What does that suggest to you?", "I see.",
            "I'm not sure I understand you fully.", "Can you elaborate?",
            "That is quite interesting." };
    responses.put("NOTFOUND", temp0);


    String[] temp1 = { "I'm sorry I do not know, but can you help me learn?" };
    responses.put("sure", temp1);

     String[] temp2 = { "I am sorry to hear you are *.",
            "How long have you been *?",
            "Do you believe it is normal to be *?", "Do you enjoy being *?" };
    responses.put("i am", temp2);
    responses.put("i'm", temp2);

    String[] temp3 = { "Tell me more about such feelings.",
            "Do you often feel *?", "Do you enjoy feeling *?",
            "Why do you feel that way?" };
    responses.put("i feel", temp3);

   //String [] temp8 = {Writer()};

    String[] temp4 = {"is that all?"};

    responses.put("now",  temp4);
      responses.put("now",Writer() );

    String[] temp5 ={ " Assignment 1", "Assignment 2"};
    responses.put("what is the current assignment", temp5);

    String[] keywords = { "i think", "i am", "i'm", "i feel","sure","learn","done","now","what is the current assignment" };