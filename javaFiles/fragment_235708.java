for (int i = 0; i < studentAnswer.length; i++) {
    String origAns = studentAnswer[i];
    for (int j = 0; j < key.length; j++) {
        if (origAns.charAt(j) == key[j]) {
           points[j] = 1;
        } else {
           points[j] = 0;
        }
    }
}