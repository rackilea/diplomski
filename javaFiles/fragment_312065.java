for (int i = 0; i < aryLines.length; i += 10) {
        // every iteration brings you to the beginning of a new question
        for (int j = 0; j < 6; j++) {
            System.out.println(aryLines[i + j]);
        }
    }