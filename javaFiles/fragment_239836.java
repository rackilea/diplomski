foos.sort(new Comparator<Foo>() {

    @Override
    public int compare(Foo o1, Foo o2) {
        //Add null check
        return  o1.getEnum().compareTo(o2.getEnum());
    }
});