/**
 * @param phones The phones
 */
@JsonProperty("phones")
public void setPhones(List<Phone> phones) {
    if ((phones != null) && (phones.size() > 1)) {
        int primaryIndex = -1;
        Phone primaryPhone = null;

        for (Phone p : phones) {
            if (p.getIsPrimary()) {
                primaryIndex = phones.indexOf(p);
                primaryPhone = p;
                break;
            }
        }

        phones.remove(primaryIndex);
        phones.add(0, primaryPhone);
    }
    this.phones = phones;
}