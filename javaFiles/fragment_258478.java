Action Syllables = new AbstractAction("Syllables") {
    public void actionPerformed(ActionEvent e) {
        ArrayList<ArrayList> words = new ArrayList();
        ArrayList<ArrayList> splitLines = new ArrayList();
        ArrayList<String> characters = new ArrayList();
        //^^goes to (As hierarchey )
        ArrayList<String> text = LinetoList(area);
        //text is a String ArrayList of every line in a text
        //LinetoList is a method that returns an ArrayList based on each new line
        for (int i = 0;  i < text.size(); i++) {
            //for each line we have
            String sentence[] =  text.get(i).split(" ");
            ArrayList<String> splitText = new ArrayList<>(Arrays.asList(sentence));
            words.add(splitText);
            }
        for (int j = 0; j < words.size(); j++) {
            String sentence [] = text.get(j).split(" ");
            ArrayList<String> splitText = new ArrayList<>(Arrays.asList(sentence));
            ArrayList<ArrayList> SplitWords = new ArrayList();
            for (int i =0; i < sentence.length; i++) {
                ArrayList<Character> SplitCharacters = new ArrayList<Character>();
                for (int k = 0; k < splitText.get(i).length(); k ++) {

                SplitCharacters.add(splitText.get(i).charAt(k));

                }
                SplitWords.add(SplitCharacters);
            }
            splitLines.add(SplitWords);

        if (words.size() ==  0)
        {System.out.println("Theres nothing here"); }
        else {
        for (int k = 0; k < words.size(); k++) {
            System.out.println("\n");
            for (int i= 0; i < words.get(k).size(); i ++) {
                System.out.println(words.get(k).get(i));
                }

            }
        System.out.println("That was the original method \n");
        for (int k = 0; k < splitLines.size(); k++) {
            System.out.println(splitLines.get(k).toString() + "\n");

            }
        }
    }       
}
};