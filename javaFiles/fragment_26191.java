public int getSize() {
    return allAnimal().size();
}
public Object getElementAt(int index) {
    return allAnimal().keySet().toArray()[index];
}