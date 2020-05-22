for (x = 0; x < wordLen; x++) {
      i = generator.nextInt(wordLen - 1); 
      j = generator.nextInt(wordLen);           
      if (j <= i)
        j = i + generator.nextInt(wordLen - i);
}