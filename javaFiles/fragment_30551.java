class Both {
    List<Foo> foos = new ArrayList<>();
    List<Bar> bars = new ArrayList<>();
    void add(CommonItem ci) {
        String name = ci.getName();
        boolean sel = ci.isSelected();
        foos.add(new Foo(name, sel));
        bars.add(new Bar(name, sel));
    }
    Both merge(Both other) {
        if(foos.isEmpty()) return other;
        foos.addAll(other.foos);
        bars.addAll(other.bars);
        return this;
    }
}