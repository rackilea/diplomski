class Comment {
    private String text;
    private List<Comment> children = new ArrayList<>();

    public Comment(String text, Comment... children) {
        this.text = text;
        this.children.addAll(Arrays.asList(children));
    }

    public String getText() {return text;}
    public void setText(String text) {this.text = text;}

    public List<Comment> getChildren() {return children;}
    public void setChildren(List<Comment> children) {this.children = children;}
}