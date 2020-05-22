public ArrayList<QuestionAnswerModal> filter(String keyword, boolean isQuestionSearch) {
    ArrayList<QuestionAnswerModal> arrayList = new ArrayList<>();
    HashMap<String, Integer> countList = new HashMap<>();

    if (isQuestionSearch) {
        for (QuestionAnswerModal modal : questionAnswerArrayList) {
            if (modal.getKeyword().equalsIgnoreCase(keyword)) {
                arrayList.add(modal);
            }
        }
        return arrayList;
    } else {
        //will store the index of the question with largest match
        int[] count = new int[questionAnswerArrayList.size()];

        for (int i = 0; i < questionAnswerArrayList.size(); i++) {
            List<String> keywords = new ArrayList<>();
            String[] word = questionAnswerArrayList.get(i).getKeyword().split(",");
            keywords = Arrays.asList(word);
            String[] userKeywords = keyword.split(",");
            for (int j = 0; j < userKeywords.length; j++) {
                if (keywords.contains(userKeywords[j])) {
                    if (countList.size() == 0) {
                        //countList.put(userKeywords[j], 1);
                        count[i]++;
                    }
                }
            }
        }

        //index with largest match
        int largest = 0;
        //valu if the index
        int largestCount = count[largest];

        for (int i = 0; i < count.length; i++) {
            if (count[i] > largestCount)
                largest = i;
        }

        arrayList.add(questionAnswerArrayList.get(largest));

        if (arrayList.size() > 0) {
            lvQuestionAnswer.invalidate();
            QuestionAnswerAdapter questionAnswerAdapter = new QuestionAnswerAdapter(arrayList, MainActivity.this, MainActivity.this, MainActivity.this);
            lvQuestionAnswer.setAdapter(questionAnswerAdapter);
            dialog.dismiss();

        } else {
            Toast.makeText(MainActivity.this, "No records found", Toast.LENGTH_SHORT).show();
        }
        return arrayList;


    }
}