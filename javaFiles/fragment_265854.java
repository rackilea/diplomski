public Double extract(String word, String tail) {
    if (tail.contains("NN") || tail.contains("NNS")
            || tail.contains("NNP")
            || tail.contains("NNPS"))
        return _dict.get(word + "#n");
    else if (tail.contains("VB") || tail.contains("VBD")
            || tail.contains("VBG") || tail.contains("VBN")
            || tail.contains("VBP") || tail.contains("VBZ")) 
        return _dict.get(word + "#v"); 
    else if (tail.contains("JJ") || tail.contains("JJR")
            || tail.contains("JJS"))
        return _dict.get(word + "#a");
    else if (tail.contains("RB") || tail.contains("RBR")
            || tail.contains("RBS"))
        return _dict.get(word + "#r");
    else
        return null;
}