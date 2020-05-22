class VeryBigClass<T extends SuperClass> {

    ArrayList<T> superList;

    public VeryBigClass(ArrayList<T> superList) {
        this.superList = superList;
    }
}