static class Result {
    private String url;
    private String title;
    private String content;
    public String getUrl() { return url; }
    public String getTitle() { return title; }
    public String getContent() {return content; }
    public void setUrl(String url) { this.url = url; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public String toString() { return "Result[url:" + url +",title:" + title + ",content:" + content + "]"; }
}