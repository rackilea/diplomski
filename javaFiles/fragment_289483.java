List<Unprocessed_DistanceTime_D> list = ...;    

class Identity {
    private final String lat;
    private final String lng;
    private final String date;
    private final String counts;

    public Identity(Unprocessed_DistanceTime_D model) {
        this.lat = model.getLat();
        this.lng = model.getLng();
        this.date = model.getDate();
        this.counts = model.getCounts();
    }

    @Override
    public int hashCode() {
        int code = 0;
        code ^= lat.hashCode();
        code ^= lng.hashCode();
        code ^= date.hashCode();
        code ^= counts.hashCode();              
        return code;
    }

    @Override
    public boolean equals(Object other) {
        if(other == null)
            return false;
        if(!(other instanceof Identity))
            return false;

        Identity io = (Identity) other;

        return lat.equalsIgnoreCase(io.lat)
            && lng.equalsIgnoreCase(io.lng)
            && date.equalsIgnoreCase(io.date)
            && counts.equalsIgnoreCase(io.counts);              
    }
}

List<Modeltest> models = list.stream()
    .collect(Collectors.groupingBy(Identity::new))
    .values().stream()
    .map(group -> { // Convert groups into single Modeltest
        if(group.size() == 1) { // Case for single entries
            Unprocessed_DistanceTime_D e = group.get(0);
            return new Modeltest(e.getLat(), e.getLng(), e.getDate(), e.getTime(),
                e.getTime(), e.getCounts(), e.getUserCode());
        }

        // Case for more entries 
        group.sort(Comparator.comparing(Unprocessed_DistanceTime_D::getTime));

        Unprocessed_DistanceTime_D first = group.get(0);
        Unprocessed_DistanceTime_D last = group.get(group.size() - 1);

        return new Modeltest(first.getLat(), first.getLng(), first.getDate(),
            first.getTime(), last.getTime(), first.getCounts(), first.getUserCode());
    })
    .collect(Collectors.toList());