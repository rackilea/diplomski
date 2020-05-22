public class Testing {
    public static void main(String[] args) {

    String html = "<div>The quick brown fox jumps over the lazy dog</div>";

    /* Access via the getInstance() getter */
    HtmlSnippitCache.getInstance().putSnippit("FOXY", html);

    /* Or via local var */
    HtmlSnippitCache cache = HtmlSnippitCache.getInstance();
    String moreHtml = cache.getSnippit("FOXY");

    System.out.println(moreHtml);
}

public static class HtmlSnippitCache {
    /* Singleton implementation */
    private static HtmlSnippitCache instance;

    public static HtmlSnippitCache getInstance() {
        if (HtmlSnippitCache.instance == null)
            synchronized (HtmlSnippitCache.class) {
                if (HtmlSnippitCache.instance == null)
                    HtmlSnippitCache.instance = new HtmlSnippitCache();
            }
        return HtmlSnippitCache.instance;
    }

    /* Ensure only local construction. */
    private HtmlSnippitCache() {}

    /* Clas Impl */
    private HashMap<String, String> map = new HashMap<String, String>();

    public boolean containsSnippit(String key) {
        return map.containsKey(key);
    }

    public String getSnippit(String key) {
        return map.get(key);
    }

    public String putSnippit(String key, String value) {
        return map.put(key, value);
    }

        public int size() {
            return map.size();
        }
    }
}