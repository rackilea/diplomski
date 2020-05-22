while (scReader.hasNext()) {
    String line = scReader.nextLine();
    if (line.equals("##Question##")) {
        strQues = scReader.nextLine();    
    } else if (line.equals("##Ans1##")) {
        ansQues[0] = scReader.nextLine();
    } else if (line.equals("##Ans2##")) {
        ansQues[1] = scReader.nextLine();
...etc