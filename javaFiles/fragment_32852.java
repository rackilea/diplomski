void generate(HashSet<String> resultList, String resultString,
        int listNum, HashMap<Integer, ArrayList<String>> data) {
    if (listNum == 0) {
        // start: begin a new resultString
        for (int i = 0; i < data.get(listNum).size(); i++) {
            generate(resultList, data.get(listNum).get(i), listNum + 1,
                    data);
        }
    } else if (listNum == data.size() - 1) {
        // end: store completed resultStrings
        for (int i = 0; i < data.get(listNum).size(); i++) {
            resultList.add(resultString + data.get(listNum).get(i));
        }
    } else {
        // middlepart: append current string to given resultString
        for (int i = 0; i < data.get(listNum).size(); i++) {
            generate(resultList, resultString + data.get(listNum).get(i),
                    listNum + 1, data);
        }
    }
}