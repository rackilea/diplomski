i = 0;
while (i < palavras.size()) {
    if (palavras.get(i).equals("REMOVE")) {
        palavras.remove(palavras.get(i));
        palavras.remove(palavras.get(i + 1));
        i += 2;
    } else {
        t.insert(palavras.get(i));
    }
    i++;
}