public class ObservableListExample implements StandardPostModificationListener,
    StandardPreModificationListener {

    public static void main(String[] args) {
        new ObservableListExample();
    }

    public ObservableListExample() {

        ObservableList list = ObservableList.decorate(new ArrayList<>(),
                new StandardModificationHandler());

        list.getHandler().addPostModificationListener(this);
        list.getHandler().addPreModificationListener(this);
        //....

    }

    @Override
    public void modificationOccurring(StandardPreModificationEvent event) {
        // before modification
        Collection changeCollection = event.getChangeCollection();
        if (event.isTypeAdd()) {
            // changeCollection contains added elements
        } else if (event.isTypeReduce()) {
            // changeCollection contains removed elements
        }
    }

    @Override
    public void modificationOccurred(StandardPostModificationEvent event) {
        // after modification
        Collection changeCollection = event.getChangeCollection();
        if (event.isTypeAdd()) {
            // changeCollection contains added elements
        } else if (event.isTypeReduce()) {
            // changeCollection contains removed elements
        }
    }
}