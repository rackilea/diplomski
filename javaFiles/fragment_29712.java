public void preOrder(int index) {

    if (index >= currSize) {
        return;
    }
    System.out.println(items[index]);
    preOrder((2 * index)+1);
    preOrder((2 * index)+2);
 }