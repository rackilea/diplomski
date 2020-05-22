public boolean equals(Object o) {
    UnchainedRestaurant r = (UnchainedRestaurant) o;
    String name1 = this.getName();
    String name2 = r.getName();

    name1 = Util.normalizeVenueName(name1);
    name2 = Util.normalizeVenueName(name2);

    if(name1.equals(name2)) {
        return true;
    } else return false;
}