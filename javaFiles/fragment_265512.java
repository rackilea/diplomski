public class MultiFileReader implements ItemReader<SomeObject> {

    private List<ItemStreamReader> readers;

    public SomeObject read() {
        SomeObject domainObject = new SomeObject();

        for(ItemStreamReader curReader : readers) {
            domainObject.add(curReader.read());
        }

        return domainObject;
    }
}