public class ChildRetrievalMapping {

    public static final ChildRetrievalMapping DEFAULT_INSTANCE = new ChildRetrievalMapping() ;

    static {
        // note the order of insertion is important: start with the more specific type

        DEFAULT_INSTANCE.put(TabPane.class, tabPane -> 
                tabPane.getTabs().stream().map(Tab::getContent).collect(Collectors.toList()));
        DEFAULT_INSTANCE.put(SplitPane.class, SplitPane::getItems);
        // others...

        // default behavior for "simple" controls, just return empty list:
        DEFAULT_INSTANCE.put(Control.class, c -> Collections.emptyList());

        // default behavior for non-control parents, return getChildrenUnmodifiable:
        DEFAULT_INSTANCE.put(Parent.class, Parent::getChildrenUnmodifiable);


        // and for plain old node, just return empty list:
        DEFAULT_INSTANCE.put(Node.class, n -> Collections.emptyList());
    }

    private final Map<Class<?>, Function<? ,List<Node>>> map = new LinkedHashMap<>();

    public <N extends Node> void put(Class<N> nodeType, Function<N, List<Node>> childRetrieval) {
        map.put(nodeType, childRetrieval);
    }

    @SuppressWarnings("unchecked")
    public <N extends Node> Function<N, List<Node>> getChildRetrieval(Class<N> nodeType) {
        return (Function<N, List<Node>>) map.get(nodeType);
    }

    @SuppressWarnings("unchecked")
    public List<Node> firstMatchingList(Node n) {
        for (Class<?> type : map.keySet()) {
            if (type.isInstance(n)) {
                return getChildRetrieval((Class<Node>) type).apply(n);
            }
        }
        return Collections.emptyList();
    }
}