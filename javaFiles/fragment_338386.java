public String getRandomStringWithExclusion(int array_id, String... exclude) {
    String[] myResArray = getResources().getStringArray(array_id);
    int idx = new Random().nextInt(myResArray.length);
    String random = (myResArray[idx]);
    boolean keepGoing = true;
    while (keepGoing) {
        //Making keepGoing be false (terminating condition),
        //And only making true if the random word fails because it has to be excluded
        keepGoing = false;
        for (String ex : exclude) {
            if (random.contains(ex)) {
                Toast.makeText(getBaseContext(), "fail", Utils.duration).show();
                keepGoing = true;
                //looking for another random word
                idx = new Random().nextInt(myResArray.length);
                random = (myResArray[idx]);
                break;
            }
        }
    }
    return random;
}