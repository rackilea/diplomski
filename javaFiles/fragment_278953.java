Comparator<Dog> comp = new Comparator<Dog>() {
    @Override
    public int compare(Dog o1, Dog o2) {
        return Integer.compare(dogNames.get(o1.getName()), dogNames.get(o2.getName()));
    }
};
System.out.println("least " + Collections.min(dogs, comp));
System.out.println("most  " + Collections.max(dogs, comp));