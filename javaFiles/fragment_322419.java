private static boolean containsLoop(final List<Element> path, Vertex current) {
    boolean loopDetected = false;

    final List<Vertex> vPath = new ArrayList<>();
    for (Element element : path) {
        if (element instanceof Vertex) {
            vPath.add((Vertex) element);
        }
    }
    vPath.add(current);

    for (Vertex v : vPath) {
        if (Collections.frequency(vPath, v) > 1) {
            loopDetected = true;
            break;
        }
    }

    return loopDetected;
}