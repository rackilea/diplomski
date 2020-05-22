class Folder{  //Can be either system or folder
    private String name;
    private String type;
    private String path;
    private List<Folder> children; //To contain subFolder
    private List<String> file; //To contain list of files
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public List<Folder> getChildren() {
        return children;
    }
    public void setChildren(List<Folder> children) {
        this.children = children;
    }
    public List<String> getFile() {
        return file;
    }
    public void setFile(List<String> file) {
        this.file = file;
    }
    @Override
    public String toString() {
        return "Folder [name=" + name + ", type=" + type + ", path=" + path + "\n, children=" + children + ", file="
                + file + "]";
    }
}