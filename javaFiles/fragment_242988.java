//always initialize the children ollections
private Set<Address> addresses = new HashSet<Address>();

//make sure equals/hashcode are implemented according to the business key semantics
//don't use the entity id for equals and hashcod

public void setAddresses(Set<Address> addresses) {  
    //1. remove the existing addresses that are not found in the new ones
    this.addresses.retainAll(addresses);
    //2. add the new addresses too, the common ones will be ignored by the Set semantics
    this.addresses.addAll(addresses);
}