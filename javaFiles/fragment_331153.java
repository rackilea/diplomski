public static String finishers(int noOfHorseInList, String horseName[], int timeTakenInSeconds[]) {
        String showHorseThatFinished = "";

        for (int i = 0; i < noOfHorseInList; i++) {
            if (timeTakenInSeconds[i] > -1) {
                showHorseThatFinished = showHorseThatFinished + "\n" + horseName[i] + "\t\t\t" + timeTakenInSeconds[i];
            }
        }
        return showHorseThatFinished;

    }