public class Acts {

    private Collection<Act> items;

    public static Collection<Act> get(NodeList acts) throws Exception {
        return new Acts(acts).items;
    }

    private Acts() {
        this.items = new ArrayList<>();
    }

    private Acts(NodeList acts) throws Exception {
        this.items = new ArrayList<>();
        for (int i = 0; i < acts.getLength(); i++) {
            Node act = acts.item(i);
            if (Node.ELEMENT_NODE == act.getNodeType()) {
                this.items.add(Act.newInstance(act));
            } else {
                // TODO something?
            }
        }
    }
}