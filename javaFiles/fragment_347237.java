for(int i=0;i<hiddenWord.length;i++) {    
        element = hiddenWord.charAt(i);
        if(userGuess==element) {   
            System.out.println("Good guess");
            userArray.remove(i);
            userArray.add(i,userGuess);
        }