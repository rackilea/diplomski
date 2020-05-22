ArrayList<String> list = fileRank.get(word);
if (list == null) {
    list = new ArrayList<String>();
    fileRank.put(word, list);
}
list.add(file1);