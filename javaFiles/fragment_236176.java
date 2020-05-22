for (int f = 0; f < text.length(); f++) {
        for (int c = 0; c < characters.length; c++) {
            int idxToGet = num + c;
            if (text.charAt(f) == characters[c] && idxToGet < characters.length) {
                pw.print(characters[idxToGet]);
            }
        }
    }