public class AddressComparator implements Comparator<Address> {

    @Override
    public int compare(Address o1, Address o2) {
        return o1.getCountry().compareTo(o2.getCountry());
    }        
}