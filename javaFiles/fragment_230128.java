JWS ws = new JWS("./lib", "3.0");
Resnik res = ws.getResnik();
TreeMap<String, Double> scores1 = res.res(word1, word2, partOfSpeech);
for(Entry<String, Double> e: scores1.entrySet())
    System.out.println(e.getKey() + "\t" + e.getValue());
System.out.println("\nhighest score\t=\t" + res.max(word1, word2, partOfSpeech) + "\n\n\n");