while ((word=readBot.readLine()) != null) {
        //spliter
        cv =0;
        spacedWord="";
        while ( cv <word.length()) {   
                spacedWord = spacedWord + " " + word.charAt(cv);
                cv = cv + 1;
            }   
            System.out.println(word + " OR " + spacedWord);
    }