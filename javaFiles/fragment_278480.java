String[][] values = {
        {"apple", "good fruit"},
        {"orange", "bad fruit"},
        {"pig", "animal"}
    };

    int maxLength = 0;

    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 2; j++) {
            if(values[i][j].length()> maxLength) {
                maxLength = values[i][j].length();
            }
        }
    }

    String format = "%d)%-" + maxLength + "s %d)%-" + maxLength + "s\n";

    for(int i = 0; i < 3; i++) {
        System.out.printf(format, i + 1, values[i][0], i + 1, values[i][1]);
    }