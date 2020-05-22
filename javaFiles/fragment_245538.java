private List<Comment> getComments(Node node) {
    List<Comment> comments = new ArrayList<Comment>();
    int i = 0;
    while (i < node.childNodes().size()) {
        Node child = node.childNode(i);
        if (child.nodeName().equals("#comment"))
            comments.add((Comment) child);
        else {
            comments.addAll(getComments(child));
        }
        i++;
    }
    return comments;
}