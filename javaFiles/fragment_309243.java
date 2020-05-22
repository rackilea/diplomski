for (int i = 0; i < students.size(); i++) {
        countIndex = 1;
        thisChoice = students.get(i).getChoices();
        for (int j = 0; j < thisChoice.size(); j++) {
            index = thisChoice.get(j);
            count[countIndex + index] = count[countIndex + index] + 1;
            countIndex += 3;
        }
    }