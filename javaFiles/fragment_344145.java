class Page {
    private int pageid;
    private int ns;
    private String title;
    private String contentmodel;
    private String pagelanguage;
    private String touched; // this could be a Date, with the appropriate format configuration
    private int lastrevid;
    private String counter;
    private int length;
    @Override
    public String toString() {
        return "Page [pageid=" + pageid + ", ns=" + ns + ", title=" + title
                + ", contentmodel=" + contentmodel + ", pagelanguage="
                + pagelanguage + ", touched=" + touched + ", lastrevid="
                + lastrevid + ", counter=" + counter + ", length=" + length
                + "]";
    }
    public int getPageid() {
        return pageid;
    }
    public void setPageid(int pageid) {
        this.pageid = pageid;
    }
    public int getNs() {
        return ns;
    }
    public void setNs(int ns) {
        this.ns = ns;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContentmodel() {
        return contentmodel;
    }
    public void setContentmodel(String contentmodel) {
        this.contentmodel = contentmodel;
    }
    public String getPagelanguage() {
        return pagelanguage;
    }
    public void setPagelanguage(String pagelanguage) {
        this.pagelanguage = pagelanguage;
    }
    public String getTouched() {
        return touched;
    }
    public void setTouched(String touched) {
        this.touched = touched;
    }
    public int getLastrevid() {
        return lastrevid;
    }
    public void setLastrevid(int lastrevid) {
        this.lastrevid = lastrevid;
    }
    public String getCounter() {
        return counter;
    }
    public void setCounter(String counter) {
        this.counter = counter;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
}