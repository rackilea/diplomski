Set<String> result = new HashSet<String>();
for(String word: words) {
    if(result.contains(word) || result.contains(new StringBuffer(word).reverse().toString())) {
        continue;
    }
    result.add(word);
}
// result