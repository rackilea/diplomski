public class ThingContainer implements List<Thing> { // Or Collection based on your needs.
    List<Thing> things;
    public boolean add(Thing thing) { things.add(thing); }
    public void clear() { things.clear(); }
    public Iterator<Thing> iterator() { things.iterator(); }
    // Etc., and create the list in the constructor
}