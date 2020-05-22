public class WordActionListener implements ActionListener {

    private String word;
    private WordListener listener

    public WordActionListener(String work, WordListener listener) {
        this.word = word;
        this.listener = listener;
    }

    public void actionPerformed(ActionEvent e) {
        listener.addWord(word);
    }
}