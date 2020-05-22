public Vector<Vector<Object>> convertMapToVector(Map<String, String> quesToAnsMap) {
    if (quesToAnsMap.size() > 0) {
        // the data field is initialized here
        data = new Vector<Vector<Object>>(quesToAnsMap.size(), 1); 
        ...
        return data;
    }
    // but not here
    return new Vector<Vector<Object>>();
}