List remList = Arrays.asList(rem);
for (Iterator it = map.keySet().iterator(); it.hasNext();) {
    String key = (String) it.next();
    String[] tokens = key.split("-");
    for (int i = 0; i < tokens.length; i++) {
        String token = tokens[i];
        if (remList.contains(token)) {
            it.remove();
            break;
        }
     }
}