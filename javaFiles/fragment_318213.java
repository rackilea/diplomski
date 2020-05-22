public Object handle(HttpResponse response, String rootName) {
    try {
        int statusCode = response.getStatusLine().getStatusCode();
        if ( statusCode >= 200 && statusCode < 300 ) {
            return createObject(response.getEntity().getContent(), rootName);
        }
        else{
            return null;
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}

public Object createObject (InputStream json, String rootName) {
    try {
        this.root = this.mapper.readTree(json);
        String className = Finder.findClassName(rootName);
        Class clazz = this.getObjectClass(className);
        return mapper.treeToValue(root.get(rootName), clazz);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}