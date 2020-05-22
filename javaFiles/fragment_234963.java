int[] original = ...;
int[] current = original;
for (int i = 0; i < original.length; i++) {
    current = moveA(current);
    printA(current);
}