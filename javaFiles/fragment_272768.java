// Do this once...
int minValueInclusive = -15;
int maxValueExclusive = 31;
boolean[] presence = new boolean[maxValueExclusive - minValueInclusive + 1];
for (int value : array) {
    presence[value - minValueInclusive] = true;
}