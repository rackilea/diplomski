Collections.sort(employeeList, new Comparator<Emp>() {
    @Override
    public int compare(Emp t, Emp t1) {
        return Float.compare(t1.getExperience(), t.getExperience());
    }
});