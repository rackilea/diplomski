char[] cLetters = letters.toCharArray();//Load letters and mask to char array for editing
 char[] cMask = mask.toCharArray();

 for(int i=0; i < cMask.length; i++){
      if(cLetters[i] == ChosenLetter.charAt(0)){
          cMask[i] = cLetters[i];
      }
  }

  mask = new String(cMask); //Load new mask into String

  System.out.println("Wordbox letters are: " + wordBox);
  System.out.println("Yes!" + mask);                        // Prints mask after Yes!