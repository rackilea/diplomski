} else if (!belongs(r)) {
    previousIP.next = r;
    previousIP = previousIP.next;
    IP = previousIP.next;
    size++;
}