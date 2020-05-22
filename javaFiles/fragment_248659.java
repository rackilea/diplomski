Pattern nonEng = Pattern.compile("[^A-Za-z]");
...
for(int i = 0; i < words.length; i++) {
    if (!pattern.matcher(words[i]).find()) {
        addToTree(words[i], root);
    }
}