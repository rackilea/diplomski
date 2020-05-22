for (int i = 0; i < phrase.length(); i++) {
      if (phrase.charAt(i) == 'a') {
          phrase = phrase.replace("a","");
          continue;  // Continue to the next loop if a has been found
      }
      ....
  }