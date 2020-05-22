public int occurrencesOfChar(TrieNode node, char c) {
    int occ = 0;
    for(TrieNode child : node.childList) {
        if(child.content == c) { 
            occ += child.count; 
        }
        occ += occurrencesOfChar(child, c);
    }
    return occ;
}