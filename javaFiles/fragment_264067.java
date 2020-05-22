class Page {
    private int page;
    private List<Threads> threads;

    public int getPage() {
        return page;
    }

    public List<Threads> getThreads() {
        return threads;
    }
}

class Threads {
    private long no;
    private String last_modified;

    public long getNo() {
        return no;
    }

    public String getLastModified() {
        return last_modified;
    }
}