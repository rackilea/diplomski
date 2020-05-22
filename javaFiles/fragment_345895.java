public void train(String sourceText){
    String[] words = sourceText.split("\\s+");

    LinkedList<ListNode> wordList = new LinkedList<>();
    outerLoop: for (int i = 0; i < words.length; i++) {
        for (ListNode node : wordList) {
            if (node.getWord().equals(words[i])) {
                if (i != words.length - 1) {
                    node.addNextWord(words[i+1]);
                }
                continue outerLoop;
            }
        }

        ListNode node = new ListNode(words[i]);
        wordList.add(node);
        if (i != words.length - 1) {
            node.addNextWord(words[i+1]);
        }            
    }

    System.out.println(wordList.size());
}