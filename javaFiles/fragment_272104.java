int index = 0;
    for (int i = 0; i <= text.length() / 2; i++) {
        String string1 = text.substring(0, i);
        String string2 = text.substring(i, 2 * i);
        if (string1.equals(string2)) {
            index = i;
        }
    }
    System.out.println("without duplicate: " + text.substring(index));