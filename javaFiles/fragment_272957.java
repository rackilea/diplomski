StringBuilder sb = new StringBuilder();
Node<T> current = endNode;
while (current != null) {
    sb.append(current).append("\n");
    current = current.getNext();
}
input = sb.toString();