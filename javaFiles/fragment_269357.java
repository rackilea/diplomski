@Override
protected void process(List<String> chunks) {
    if (isCancelled()) return;
    String string = chunks.get(chunks.size() - 1);
    textArea.append(string);
}