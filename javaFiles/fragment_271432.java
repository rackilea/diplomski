char sec,fir;
    boolean lastPrinted = false;
    for (int i = 0; i < st1.length() - 1; i++) {
        fir = st1.charAt(i);
        sec = st1.charAt(i + 1);
        if (fir + 1 == sec) {
            if (!lastPrinted) {
                System.out.print(fir);
            }
            System.out.print(sec);
            lastPrinted = true;
        } else {
            lastPrinted = false;
        }
    }