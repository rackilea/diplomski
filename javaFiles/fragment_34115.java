public void add(Distance... distance) {
    for(Distance d : distance) {
        feet += d.getFeet();
        if(inches + d.getInches >= 12)
            feet++;
        inches += d.getInches() % 12;
    }
}