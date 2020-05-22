public class Business extends Contact {
    private static final String TYPE = "Business";
    ...
    @Override // method on Contact
    public String getType() {
        return TYPE
    }