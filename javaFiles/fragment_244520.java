String s = "This is the work (my real job) which is great, and (also some stuff";

     ArrayList<String> words = new ArrayList<String>();
     Scanner sentence = new Scanner(s);
     boolean inParen = false;
     StringBuilder inParenWord = new StringBuilder();
     while(sentence.hasNext()) {
        String word = sentence.next();
        if(inParen) {
           inParenWord.append(" ");
           inParenWord.append(word);

           if(word.endsWith(")")) {
              words.add(inParenWord.toString());
              inParenWord = new StringBuilder();
              inParen = false;
           }
        }
        else {
           if(word.startsWith("(")) {
              inParen = true;
              inParenWord.append(word);
           }
           else {
              words.add(word);
           }
        }
     }

     if(inParenWord.length()>0) {
        words.add(inParenWord.toString());
     }


     for(String word : words) {
        System.out.println(word);
     }