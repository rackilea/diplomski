public void writeOutput() {
    boolean processRunning = true;
    BufferedWriter bufferedWriter = null;
    try {
        bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        while (processRunning) {
            String s = generateOutput();
            bufferedWriter.write(s);
            if (s.equals("finished")) {
                processRunning = false;
            }
        }
        bufferedWriter.flush();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}