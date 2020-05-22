String current = "";
 for (int i = 0; i < goldWords.length(); i++){
     for (int j = 0; j < N_GRAM_ORDER; j++){
            if (i + j < goldWords.length())
                 current += ":" + goldWords[i + j];
     }
     goldNGrams.add(current);
     current = "";
 }