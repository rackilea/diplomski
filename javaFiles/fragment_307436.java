public class ObjParser {
    private static final Pattern vertexLinePattern = Pattern.compile("^v\\s(.+)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    private static final Pattern faceLinePattern = Pattern.compile("^f\\s(.+)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    private static final Pattern vertexValuePattern = Pattern.compile("([0-9\\-\\.]+)");
    private static final Pattern faceValuePattern = Pattern.compile("([0-9]+)");

    private List<Float> vertices = new LinkedList<Float>();
    private List<Short> faces = new LinkedList<Short>();

    public void parseVertices(String data) {
        Matcher matcher1 = vertexLinePattern.matcher(data);
        while(matcher1.find()) {
            String line = matcher1.group(1);

            Matcher matcher2 = vertexValuePattern.matcher(line);
            while(matcher2.find()) {
                vertices.add(Float.parseFloat(matcher2.group(1)));
            }
        }
    }

    public void parseFaces(String data) {
        Matcher matcher1 = faceLinePattern.matcher(data);
        while(matcher1.find()) {
            String line = matcher1.group(1);

            Matcher matcher2 = faceValuePattern.matcher(line);
            while(matcher2.find()) {
                short no = (short)(Integer.parseInt(matcher2.group(1)) - 1); // -1 due to 1 based index in OBJ files
                faces.add(no);
            }
        }
    }

    public List<Float> getVertices() {
        return vertices;
    }

    public List<Short> getFaces() {
        return faces;
    }
}