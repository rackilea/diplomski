if (tagPairs.containsKey(fileContent.get(i))) {
    // current top of the stack is a parent for new opening tag 
    String parent = openingTags.peek(); 
    if (!parents.get(fileContent.get(i)).equals(parent)) {
        return false;
    }
    openingTags.push(fileContent.get(i));
}