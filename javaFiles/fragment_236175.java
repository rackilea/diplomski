for (int f = 0; f < text.length(); f++) {
        for (int c = 0; c < characters.length; c++) {
            if (text.charAt(f) == characters[c]) {
                int idxToGet = (num + c) % characters.length;
                pw.print(characters[idxToGet]);
            }
        }
    }