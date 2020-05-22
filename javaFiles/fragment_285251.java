public void run() {
    char[] expected = { 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z', 'z' };
    while (timesModified < 100 && !Arrays.equals(array, expected)) {
        try {
            array[findMinIndex(array)] = rndChar();
            timesModified++;
            Thread.sleep(2000);
            StringBuilder sb = new StringBuilder();
            for (char c : array) {
                sb.append(c + " ");
            }
            System.out.println(sb);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}