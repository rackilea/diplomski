import java.text.*;

/* ... */

Node generateHuffmanSubTree(CharacterIterator iterChar) {
    char ch = iterChar.current(); 
    iterChar.next();
    Node node = new Node();
    if (ch == '1') { // a leaf
        Sign sign = new Sign();
        sign.setCharacter(iterChar.next()); // skip "[" and get char
        iterChar.next();
        iterChar.next(); // skip "]"
        node.setSign(sign);
    } else { // can only be "0", so no IF is needed here
        node.setLeft(generateHuffmanSubTree(iterChar));
        node.setRight(generateHuffmanSubTree(iterChar));
    }
    return node;
}

Node getHuffmanTree(String treeCode) {
    return generateHuffmanSubTree(new StringCharacterIterator(treeCode));
}