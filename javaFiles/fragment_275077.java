List<Child> sortedList = 
    session.createQuery("select c from Child c where c.parent = :parent order by c.index")
           .setParameter("parent, parent)
           .list();
List<Child> indexedList = new ArrayList<Child>();
for (Child child : sortedList) {
    indexedList.ensureCapacity(child.getIndex() + 1);
    indexedList.set(child.getIndex(), child);
}