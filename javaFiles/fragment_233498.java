public static void main(String [] args) {

    Scanner scInput = new Scanner(System.in);
    String word = scInput.nextLine();

    int total = 0;
    int tensValue = 0; //number's tens value (i.e. 30)
    int onesValue = 0; //ones value (i.e. 3)

    int divider = word.indexOf('-');
    String tens = null;
    String ones = null;
    if (divider != -1) {
        tens = word.substring(0, divider);
        ones = word.substring(divider + 1);
    } else {
        ones = word;
    }

    //searches for matches in String array for tens
    if (tens != null) {
        for (int u = 0; u < wTENS.length; u++) {
            if (tens.equals(wTENS[u])) {
                tensValue = nTENS[u];
                total += tensValue;
            }
        }
    }

    //searches for matches in String array for ones
    for(int u = 0; u < wONES.length; u++) {
        if (ones.equals(wONES[u])) {
            onesValue = nONES[u];
            total += onesValue;
        }
    }

    // if a "teen" override what's in total
    for(int u = 0; u < wTEENS.length; u++) {
     if (ones.equals(wTEENS[u])) {
         total = nTEENS[u];
     }
    }

    System.out.println(total);
}