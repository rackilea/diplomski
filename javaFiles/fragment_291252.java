boolean dup = false;
for (int i = 0 ; i != counter ; i++) {
    if (listA[i] == inputListA) {
        dup = true;
        break;
    }
}
// If we went through listA up to count and dup remained false,
// listA must be a new number; otherwise, it's a duplicate.
if (dup) {
    System.out.println(inputListA + " was already added to the array, enter a different number");
}