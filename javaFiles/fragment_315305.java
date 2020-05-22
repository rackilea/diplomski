int recipient1ID = 1111;
    int recipient2ID = 2222; 

    LinkedVar<Integer> conversation = new LinkedVar<>();
    conversation.put(recipient1ID, recipient2ID);// add link

    System.out.println(conversation.get(recipient1ID));// returns recipient2ID
    System.out.println(conversation.get(recipient2ID));// returns recipient1ID