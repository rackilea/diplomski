public class PageNode {
    public String title;
    public String url;
    /* Getters/setter/constructor etc. if you feel like*/
    public String toString() {
       return title;
    }
}

public class ChapterNode {
    public String title;
    public ArrayList<PageNode> pages = new ArrayList<PageNode>();
    /* Getters/setter/constructor etc. if you feel like*/
}