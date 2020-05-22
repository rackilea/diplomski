public class Routes {

    private final Collection<Route> items;

    public static Collection<Route> get(Node routes) throws Exception {
        return new Routes(routes).items;
    }

    private Routes() {
        this.items = new ArrayList<>();
    }

    private Routes(Node routes) throws Exception {
        this.items = new ArrayList<>();
        NodeList routesList = routes.getChildNodes();
        for (int i = 0; i < routesList.getLength(); i++) {
            Node route = routesList.item(i);
            if (Node.ELEMENT_NODE == route.getNodeType()) {
                items.add(Route.newInstance(route));
            } else {
                // TODO something?
            }
        }
    }   
}