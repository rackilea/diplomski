int countArray[]  = new int[wordFreqMap.size()];
    int i=0;
    for (Map.Entry<String, Integer> entry : wordFreqMap.entrySet()) {
        String tempWord = entry.getKey();
        Integer wf = entry.getValue();
        System.out.println(tempWord + " " + "count is= " + wf);
        countArray[i++] = wf;

    }