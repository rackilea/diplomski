for (int i= 0; i < original.length(); i++) {
            storagelocation[i] = i;
            letter1[i] = letters[i];
            if (letter1[i] == original.charAt(i)) {
                letter1[i] = init[i];
            }
 }