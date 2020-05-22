records.sort(new Comparator<VehicleRegistration>() {
    @Override
    public int compare(VehicleRegistration v1, VehicleRegistration v2) {
        return v1.timestamp.compareTo(v2.timestamp);
    }
});
Collections.reverse(records);