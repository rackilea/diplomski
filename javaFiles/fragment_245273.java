public Font(String name, int style, int size) {
    this.name = (name != null) ? name : "Default";
    this.style = (style & ~0x03) == 0 ? style : 0;
    this.size = size;
    this.pointSize = size;
}