for (int i = 1; i <= 3; i++) {
    int max = -1;
    Character maxKey = 'a';
    for (Character key : list.keySet()) {
        if (list.get(key) > max) {
            max = list.get(key);
            maxKey = key;
        }
    }
    System.out.println(i + ": " + maxKey + " " + max );
    list.remove(maxKey);
}