public void compare(int[] arrayA, int[] arrayB) {
    int sameIndex = 0;
    int diffIndex = 0;
    //Made two new empty arrays to save the status of each element in the corresponding array, whether it has been checked our not, if not, it'd be null.
    String[] arrayAstatus = new String[arrayA.length];
    String[] arrayBstatus = new String[arrayB.length];
    for (int i = 0; i < arrayA.length; i++) {            
        if (arrayA[i] == arrayB[i] || arrayAstatus[i] != null) {
            sameIndex++;
            continue;
        }
        for (int a = 0; a < arrayB.length; a++) {
            if (a == i || arrayBstatus[a] != null) {
                continue;
            }
            if (arrayA[i] == arrayB[a]) {
                arrayAstatus[i] = "checked";
                arrayBstatus[a] = "checked";
                diffIndex++;
                break;
            }
        }
    }
    System.out.println(sameIndex + ", " + diffIndex);
}