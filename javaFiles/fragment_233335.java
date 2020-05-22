HashMap<String, BigDecimal> runningTdIDF = new HashMap<String, Double>();
HashMap<String, BigDecimal> wordCount = new HashMap<String, Double>();
HashMap<String, BigDecimal> frequency = new HashMap<String, Double>();
HashMap<String, BigDecimal> inverseTF = new HashMap<String, Double>();
for (int i = 0; i < array2.length; i++) {

    totalCount = 0;
    wordCountVal = 0;

    Scanner s = new Scanner(file);
    {
        while (s.hasNext()) {
            totalCount++;
            if (s.next().equals(array2[i]))
                 wordCountVal++;

            }

            BigDecimal wordCount(array2[i],new BigDecimal(wordCountVal));

            BigDecimal frequencyVal = new BigDecimal( (double) wordCount / totalCount));
        frequency.put(array2[i],frequencyVal);

            BigDecimal inverseTFVal =  new BigDecimal(Math.log10((float) numDoc
                            / (numofDoc[i])));
        inverseTF.put(array2[i], inverseTFVal);


            BigDecaim TFIDF =new BigDecima( (( wordCount / totalCount) * inverseTF));
            runningTfIDF.put(array2[i], TFIDF);

    }

    for(String word : wordCount.keySet()){
         System.out.print(word + " --> word count " 
        + "\t |"+wordCount.get(word)+"|");
         System.out.print("  Total count = " + "\t " + "|"
             + totalCount + "|");
         System.out.printf("  Term Frequency =  | %8.4f |",
             frequency.get(word));

         System.out.println("\t ");

         System.out.println("    --> IDF = " + inverseTF.get(word));

         System.out.println("    --> TF/IDF = " + runningTfIDF.get(word) + "\n");
    }