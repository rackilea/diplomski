boolean inOrder = true;
for (int count = 0; count < 9; count++) {
    if (Array[count + 1] < Array[count]) {
        inOrder = false;
        break;
    }
}

if (inOrder) {
    System.out.println("Array is in order.");
} else {
    System.out.println("Array is not in order.");
}