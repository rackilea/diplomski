while (curr.next != null) {
curr = curr.next;
    result += curr.data;
    if (curr.next != null)
        result += ", ";
}