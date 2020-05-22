public String toString() {
    if(isEmpty()) {
        return "";
    }
    StringBuilder sb = new StringBuilder(top.toString());
    LinearNode<T> next = top.next();
    while(next != null) {
        sb.append("\n").append(next);
        next = next.next();
    }
    return sb.toString();
}