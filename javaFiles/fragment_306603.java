try {
        InputSR = new InputStreamReader(am.open("test_scores.txt"));
        BufferedRdr = new BufferedReader(InputSR);
        // open input stream test_scores for reading purpose.
        int i = 0;
        while ((thisLine = BufferedRdr.readLine()) != null) {
            // System.out.println(thisLine);

            String[] parts = thisLine.split(" ");
            testScoreList[i][0] = parts[0];
            testScoreList[i][1] = parts[1];
            i = i +1;
        }
    } catch (Exception e) {
        e.printStackTrace();

    }