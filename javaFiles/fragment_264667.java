List<Map.Entry<Object, Long>> sorted = 
    new ArrayList<>(frequentPhrases.asMap().entrySet());
Collections.sort(sorted, Collections.reverseOrder(Map.Entry.comparingByValue()));

for (Map.Entry<Object, Long> entry : sorted) {
    System.out.println(entry); // Or something more useful
}