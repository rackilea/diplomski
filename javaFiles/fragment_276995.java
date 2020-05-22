public int yourMaxBlock(String str) {
    int maxCounter = 1;
    int counter = 1;
    if (str.length() == 0) {
        return 0;
    }
    for (int i = 0; i < str.length() - 1; i++) {
        if (str.substring(i, i + 1).equals(str.substring(i + 1, i + 2))) {
            counter++;

        }
        if (counter > maxCounter) {
            maxCounter = counter;
            counter = 0;
        }
    }

    return maxCounter;
}

public int myMaxBlock(String str) {
    int maxCounter = 1;
    int counter = 1;
    if (str.isEmpty()) {
        return 0;
    }
    for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i - 1) == str.charAt(i)) {
            if (++counter > maxCounter) {
                maxCounter = counter;
            }
        } else {
            counter = 1;
        }
    }

    return maxCounter;
}

public void test() {
    String[] tests = new String[]{
        "", "+", "++", "+++,++,++,+", "+,++,+++,++,", "+,++,+++,++++", "+++++,++,+++,++++"
    };
    for (String s : tests) {
        int myMax = myMaxBlock(s);
        int yourMax = yourMaxBlock(s);
        System.out.println("myMaxBlock(" + s + ") = " + myMax + (myMax != yourMax ? " WRONG! you have " + yourMax : ""));
    }
}