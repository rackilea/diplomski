static final int root_depth = 4; // assuming 4 whitespaces precede the tree root

public Section(String text, int depth) {
    this.text     = text;
    this.depth    = depth;
    this.children = new ArrayList<Section>();
    this.parent   = null;
}

public Section(String text, int depth, Section parent) {
    this.text     = text;
    this.depth    = depth;
    this.children = new ArrayList<Section>();
    this.parent   = parent;
}