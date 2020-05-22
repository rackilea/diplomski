void printInorder(int index) {
    if (index == -1) return;
    printInorder(left[index]);
    System.out.print(keys[index] + " ");
    printInorder(right[index]);
}