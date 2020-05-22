public static List<String> twoBeds() {
    List<String> matchedAddresses = new ArrayList<>();
    for (ListIterator<House> it = agency.listIterator(); it.hasNext(); ) {
        House h = it.next();
        if (h.bedrooms == 2) {
            matchedAddresses.add(h.address);
        }
    }
    return matchedAddresses;
}