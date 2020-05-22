public boolean isSolved() {
    try {
        int i = Integer.parseInt(dig1);
        int j = Integer.parseInt(dig2);
        int k = Integer.parseInt(res);
        return (i+j) == k;
    }
    catch (NumberFormatException e) {
        return false;
    }
 }