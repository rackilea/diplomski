String temp = "";
    int counter = 0, counter2 = 0;

    for (int i = 0; i < a.length; i++) {
        if (!a[i].equals(temp))
            temp = a[i];
        else {
            a[i] = "";
            counter++;
        }
    }

    String[] result = new String[a.length - counter];

    for (int i = 0; i < a.length; i++) {
        if (a[i].equals("")) continue;
        result[counter2] = a[i];
        counter2++;
    }

    return result;
}