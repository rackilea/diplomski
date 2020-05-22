string word = "test";
        char letter = 'e';
        string secretWord = "????";
        int index = word.indexOf(letter);
        if(index >= 0)
        {
         secretWord = secretWord.substring(0,index)+letter+secretWord.substring(index + 1);
         System.out.println(secretWord);
        }