class BSONDBObject extends BasicBSONObject implements DBObject {
    boolean ispartial = false;
    public BSONDBObject(BSONObject source) {
        this.putAll(source);
    }
    public boolean isPartialObject() {
        return ispartial;
    }
    public void markAsPartialObject() {
        this.ispartial = true;
    }
}