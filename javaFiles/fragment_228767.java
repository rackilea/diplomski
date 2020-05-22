public enum ContactType {
    Personal, Bussiness
}

public class Business extends Contact {
    private static final ContactType TYPE = ContactType.Business;
    ...
    @Override // method on Contact
    public ContactType getType() {
        return TYPE
    }