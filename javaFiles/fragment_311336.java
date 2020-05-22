int index = 0;
int max = scores[0];
for (int i = 1; i < scores.length; i++) {
    if (scores[i] > max) {
        index = i;
        max = scores[i];
    }
}
System.out.printf("Max Name: %s Max Score: %s", sNames[index], max);