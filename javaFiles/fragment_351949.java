public class JXPathVisitBrowser {
    private JXPathContext context;
    public JXPathVisitBrowser(Object object) {
        context = JXPathContext.newContext(object);
    }
    public <T> void applyVisitor(String query, AbstractVisitor<T> visitor) {
        Iterator iter = context.iterate(query);
        while (iter.hasNext())
            visitor.visit((T) iter.next());
    }
}