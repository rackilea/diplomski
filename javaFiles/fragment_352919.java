Set<Project> projects = new TreeSet<>(new Comparator<Project>() {
    @Override
    public int compare(Project o1, Project o2) {
        if (o1.getLabel().equals("foo")) return -2;
        if (o1.getLabel().equals("Solar")) return -1;
        if (o1.getLabel().equals("Gov")) return 1;
        return 0;
    }
});