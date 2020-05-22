public void replace (String item, String newItem, Node n) {
    if (n != null) {
        n.data = n.data.replace(item, newItem); // String.replace
        replace(item, newItem, n.next()); // Recursion
    }
}