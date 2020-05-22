StringBuilder sb = new StringBuilder();
for(Node<T> current = endNode
    ; current != null
    ; current = current.getNext()){
    sb.append(current).append("\n");
}
input = sb.toString();