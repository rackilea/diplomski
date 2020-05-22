private String parse(String text) {
    // create the header line
    StringBuilder csv = new StringBuilder("Sl No,Question,Option A,Option B,Option C");

    // get every line in an array
    String[] array = text.split("\n");

    // for every 4 lines
    for(int i=0; i<array.length; i = i+4) {
        String question = array[i];
        String optionA = array[i+1];
        String optionB = array[i+2];
        String optionC = array[i+3];
        String questionNo = question.substring(0, question.indexOf(".")).trim();
        String questionText = question.substring(question.indexOf(".")+1).trim();
        String optionAText = optionA.substring(optionA.indexOf(" ")).trim();
        String optionBText = optionB.substring(optionB.indexOf(" ")).trim();
        String optionCText = optionC.substring(optionC.indexOf(" ")).trim();

        // build the corresponding csv line
        String csvLine = questionNo+","+questionText+","+optionAText+","+optionBText+","+optionCText;
        csv.append("\n");
        csv.append(csvLine);
    }
    return csv.toString();
}