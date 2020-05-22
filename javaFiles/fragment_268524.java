public void insert(Rational r) {
    if (isEmpty()) {
        first = new RationalNode(r);//changed
        previousIP = first;
        IP = previousIP.next;
        size++;
    } else if (!belongs(r)) {
        previousIP.next = new RationalNode(r);//changed
        previousIP = previousIP.next;
        IP = previousIP.next;
        size++;
    }
}