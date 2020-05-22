private SoloNode head;

public Solo(Phrase myPhrase)
{
    int length = myPhrase.length();
    SoloNode node = new SoloNode();
    head = node;
    for (int i = 0; i < length; i++) {
        node.setNote(myPhrase.getNote(i));
        if (i + 1 < length) {
            node.setNext(new SoloNode());
            node = node.getNext();
        }
    }
}