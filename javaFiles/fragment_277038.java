while (scReader.hasNext()) {
    if (scReader.nextLine().equals("##Question##")) {
        strQues = scReader.nextLine();    
    } else if (scReader.nextLine().equals("##Ans1##")) {
        ansQues[0] = scReader.nextLine();
    } else if (scReader.nextLine().equals("##Ans2##")) {
        ansQues[1] = scReader.nextLine();
...etc