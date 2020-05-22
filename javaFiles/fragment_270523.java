public class KeyWordInfo {
    public enum Location {BODY, INFO_BOX; REF_SECTION};
    private int count = 0;
    private String documentId;
    private Set<Location> locations;
    public KeyWordInfo(int count, String documentId, Location... locations) {
        this.count = count;
        this.documentId = documentId;
        this.locations = EnumSet.of(locations);
    }
    //...getters, maybe setters
}

//usage
Map<String, KeyWordInfo> keyWordMap = new TreeMap<>();
keyWordMap.put("test", new KeyWordInfo(42,"doc0815",BODY,INFO_BOX));