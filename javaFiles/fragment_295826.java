public void print() {
    current = head;
    System.out.print(current.coef + "x^" + current.exp);
    while (current.next != null) {
        current = current.next;
        System.out.print(" + " + current.coef + "x^" + current.exp);
    }
    System.out.println();
}