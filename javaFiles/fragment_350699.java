String current = "";
 for (int i = 0; i < goldWords.length(); i++){
     if (i + N_GRAM_ORDER < goldWords.length()){
         for (int j = 0; j < N_GRAM_ORDER; j++){
                 current += ":" + goldWords[i + j];
         }
     }
     goldNGrams.add(current);
     current = "";
 }