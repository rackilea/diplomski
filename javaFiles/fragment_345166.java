public class Solution {

    private final double cost;

    private final Collection<Route> routes;

    public static final Solution newInstance(Node solution) throws Exception {
        return new Solution(solution);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("solution:");
        sb.append(System.lineSeparator());
        sb.append("--------");
        sb.append(System.lineSeparator());
        sb.append("cost:");
        sb.append(this.cost);

        for (Route route : this.routes) {
            sb.append(route.toString());
        }

        return sb.toString();
    }

    private Solution(Node solution) throws Exception {
        if (solution.getNodeType() == Node.ELEMENT_NODE) {
            Element solutionElement = (Element) solution;
            this.cost = Double.valueOf(solutionElement.getElementsByTagName("cost").item(0).getTextContent());
            this.routes = Routes.get(solutionElement.getElementsByTagName("routes").item(0));
        } else {
            // TODO something?
            this.cost = 0D;
            this.routes = Collections.emptyList();
        }
    }
}