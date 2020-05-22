for (int i = 0; i < studentAnswer.length; i++) {
    String origAns = studentAnswer[i];
    for (int j = 0; j < key.length; j++) {
        points[j] = origAns.charAt(j) == key[j] ? 1 : 0;
    }
}