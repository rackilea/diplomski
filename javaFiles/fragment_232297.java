// Add a copy constructor
public Bean(Bean other) {
    this.id = other.id;
    this.nom = other.nom;
}
// Make copies in getClone()
public ArrayList<Bean> getClone() {
        ArrayList<Bean> r = new ArrayList<>(2);
        r.add(new Bean(str.get(2)));
        r.add(new Bean(str.get(3)));
        return r;
    }
}