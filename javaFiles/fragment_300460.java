public class JQuery
{

    private final List<HElement> es;
    private final JQuery parent;
    public interface Func<T>
    {
        T apply(final HElement element, final int index);
    }

    static public JQuery $(HElement e)
    {
        return new JQuery(null, e == null ? Collections.<HElement>emptyList() : Collections.singletonList(e));
    }

    static public JQuery $(Collection<HElement> es)
    {
            return new JQuery(null, new ArrayList<HElement>(es));
    }

    static public JQuery $(String selector, HElement e)
    {
            return new JQuery(null, e.selectAll(selector));
    }

    static public JQuery $(String selector, HtmLayout layout)
    {
            return new JQuery(null, layout.getRoot().selectAll(selector));
    }

    static public JQuery $(String selector, Collection<HElement> es)
    {
            final ArrayList<HElement> result = new ArrayList<HElement>();
            for(HElement e : es)
            {
                    result.addAll(e.selectAll(selector));
            }
            return new JQuery(null, result);
    }


    public JQuery find(String selector)
    {
        final ArrayList<HElement> result = new ArrayList<HElement>();
        for(HElement e : es)
            result.addAll(e.selectAll(selector));
        return new JQuery(this, result);
    }

    public JQuery text(String value)
    {
            for(HElement e : es)
            {
                    e.setInnerText(value);
            }
            return this;
    }

    public String text()
    {
            final StringBuilder value = new StringBuilder();
            for(HElement e : es)
            {
                    value.append(e.getInnerText());
            }
            return value.toString();
    }

    public int size()
    {
            return es.size();
    }
    public JQuery children()
    {
            final List<HElement> result = new ArrayList<HElement>(size());
            for(HElement e : es)
        for (HElement c : e.children())
            if(c!=null)// Avoid null TD in TR
                result.add(c);
            return new JQuery(this, result);
    }

    public JQuery children(String selector)
    {
            return children().filter(selector);
    }

    public JQuery filter(final String selector)
    {
            final List<HElement> result = new ArrayList<HElement>(size());
            for(HElement e : es)
            {
                    if(e.selectParentOrSelf(selector, 1) != null)
                            result.add(e);
            }
            return new JQuery(this, result);
    }


}