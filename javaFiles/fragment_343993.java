class CustomType {
    private Map<ClusterType, String> map;

    @JsonAnyGetter // necessary to unwrap the Map to the root object, see here: http://jira.codehaus.org/browse/JACKSON-765
    @JsonSerialize(keyUsing = ClusterTypeKeySerializer.class)
    public Map<ClusterType, String> getMap() {
        return map;
    }

    public void setMap(Map<ClusterType, String> map) {
        this.map = map;
    }
}