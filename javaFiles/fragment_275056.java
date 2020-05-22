class JSONObjectComparator implements Comparator<JSONObject> {
    private String fieldToCompare = null;
    public JSONObjectComparator(String fieldToCompare) {
        this.fieldToCompare = fieldToCompare;
    }
    @Override
    public int compare(JSONObject o1, JSONObject o2) {
        return o1
                .get(fieldToCompare)
                .isString()
                .stringValue()
                .compareToIgnoreCase(
                        o2.get(fieldToCompare).isString().stringValue());
    }
}