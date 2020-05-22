private void processCommand(int [] array) {
    if (array.length <= 1)
        {return;}

    int[] left = leftHalf(array);
    int[] right = rightHalf(array);
    Thread rightThread = null;

    if (b <= 5) {
        ++b;
        Mergesorts worker = new Mergesorts(right);
        rightThread = new Thread(worker);
        rightThread.start();
    } else {
        processCommand(right);
    }

    processCommand(left);

    if (null != rightThread) {
        try {
            rightThread.join();
            b--
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            // better error handling would be good
        }
    }

    merge(array, left, right);
}