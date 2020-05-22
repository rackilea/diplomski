public enum DocumentType {

    .... existing enum stuff here

    private static final Map<String, DocumentType> typesByLabel = new HashMap<String, DocumentType>();
    static {
        for(DocumentType documentType : DocumentType.values()){
            typesByLabel.put(documentType.label, documentType);
        }
    }

    public static DocumentType getDocumentType(String label){
        if (typesByLabel.containsKey(label)) {
            return typesByLabel.get(label);
        } else {
            return UNKNOWN;
        }
    }
}