public static void main(String[] args) throws Exception {
    BufferedReader br1 = null;
    BufferedReader br2 = null;
    BufferedWriter bw3 = null;
    String sCurrentLine;
    int linelength;

    HashMap<String, Integer> expectedrecords = new HashMap<String, Integer>();
    HashMap<String, Integer> actualrecords = new HashMap<String, Integer>();

    br1 = new BufferedReader(new FileReader("expected.txt"));
    br2 = new BufferedReader(new FileReader("actual.txt"));

    while ((sCurrentLine = br1.readLine()) != null) {
        if (expectedrecords.containsKey(sCurrentLine)) {
            expectedrecords.put(sCurrentLine, expectedrecords.get(sCurrentLine) + 1);
        } else {
            expectedrecords.put(sCurrentLine, 1);
        }
    }
    while ((sCurrentLine = br2.readLine()) != null) {
        if (expectedrecords.containsKey(sCurrentLine)) {
            int expectedCount = expectedrecords.get(sCurrentLine) - 1;
            if (expectedCount == 0) {
                expectedrecords.remove(sCurrentLine);
            } else {
                expectedrecords.put(sCurrentLine, expectedCount);
            }
        } else {
            if (actualrecords.containsKey(sCurrentLine)) {
                actualrecords.put(sCurrentLine, actualrecords.get(sCurrentLine) + 1);
            } else {
                actualrecords.put(sCurrentLine, 1);
            }
        }
    }

    // expected is left with all records not present in actual
    // actual is left with all records not present in expected
    bw3 = new BufferedWriter(new FileWriter(new File("c.txt")));
    bw3.write("Records which are not present in actual\n");
    for (String key : expectedrecords.keySet()) {
        for (int i = 0; i < expectedrecords.get(key); i++) {
            bw3.write(key);
            bw3.newLine();
        }
    }
    bw3.write("Records which are in actual but not present in expected\n");
    for (String key : actualrecords.keySet()) {
        for (int i = 0; i < actualrecords.get(key); i++) {
            bw3.write(key);
            bw3.newLine();
        }
    }
    bw3.flush();
    bw3.close();
}