interface ListA extends List<A> {
    // Put additional methods here
}
class ListAImpl implements ListA {
    private List<A> content;
    public ListAImpl(List<A> content) {
        this.content = content;
    }
    // Use delegation for all methods of the List<A> interface, calling through
    // to the content list.
}