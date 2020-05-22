public class Act {

    private final String service;

    private final double arrTime;

    private final double endTime;

    public static Act newInstance(Node act) throws Exception {
        return new Act(act);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Act");
        sb.append(System.lineSeparator());
        sb.append("arr time");
        sb.append(System.lineSeparator());
        sb.append(this.arrTime);
        sb.append(System.lineSeparator());
        sb.append("end time:");
        sb.append(System.lineSeparator());
        sb.append(this.endTime);
        sb.append(System.lineSeparator());
        sb.append("service:");
        sb.append(System.lineSeparator());
        sb.append(this.service);

        return sb.toString();
    }

    private Act(Node act) throws Exception {
        Element actElement = (Element) act;
        this.service = actElement.getAttribute("service");
        this.arrTime = Double.valueOf(actElement.getElementsByTagName("arrTime").item(0).getTextContent());
        this.endTime = Double.valueOf(actElement.getElementsByTagName("endTime").item(0).getTextContent());
    }
}