public static List<List<String>> splitData(List<String> data) {
        List<List<String>> splittedData = new ArrayList<List<String>>();
        List<String> currentSplit = null;
        for (int i = 0; i < data.size(); i++) {
            if (i % 10 == 0) {
                currentSplit = new ArrayList<String>();
                splittedData.add(currentSplit);
            }
            currentSplit.add(data.get(i));
        }
        return splittedData;
    }