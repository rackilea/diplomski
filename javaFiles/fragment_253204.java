public static void displayInOrderOfOccurrence(
        Map<String, WordOccurrence> words) {

    List<WordOccurrence> orderedByOccurrence = new ArrayList<>();

    // sort
    for (Map.Entry<String, WordOccurrence> entry : words.entrySet()) {
        WordOccurrence wo = entry.getValue();

        // initialize the list on the first round
        if (orderedByOccurrence.isEmpty()) {
            orderedByOccurrence.add(wo);
        } else {

            for (int i = 0; i < orderedByOccurrence.size(); i++) {
                if (wo.compareTo(orderedByOccurrence.get(i)) > 0) {
                    orderedByOccurrence.add(i, wo);
                    break;
                } else if (i == orderedByOccurrence.size() - 1) {
                    orderedByOccurrence.add(wo);
                    break;
                }
            }
        }
    }

    // display
    for (WordOccurrence wo : orderedByOccurence) {
        System.out.println(wo);
    }
}