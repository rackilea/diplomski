public static void processArray(ArrayList<Integer> array) {
    // process from end of list backward
    int ix = array.size();
    while (ix > 0) {
        if (array.get(ix - 1) % 10 == 6) {
            // find beginning of run of numbers that end in 6
            int beginIx = ix - 1;
            while (beginIx > 0 && array.get(beginIx - 1) % 10 == 6) {
                beginIx--;
            }
            List<Integer> runOf6 = array.subList(beginIx, ix);
            if (runOf6.size() >= 2) {
                // delete entire run
                runOf6.clear();
            }
            ix = beginIx;
        }
        else {
            ix--;
        }
    }
}