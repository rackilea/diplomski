public class TrieNode {

    // make child nodes
    private TrieNode[] c;
    // flag for end of word
    private boolean flag = false;
    //stores frequency if flag is set
    private int frequency;