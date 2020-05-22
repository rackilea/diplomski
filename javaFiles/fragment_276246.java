class CVSParser<T> {
    private final RecordHandler<T> handler;

    public CVSParser<T>(RecordHandler<T> handler) {
       this.handler = handler;
    }

    public Set<T> parse(File f) {
        Set<T> records = new TreeSet<T>();
        for (String line : file ) {  //I'm paraphrasing here
           records.add(handler.parse( splitIntoFields(line) ));
        }
    }
}

interface RecordHandler<T> {
    public T parse(String[] fields);
}

class CustomerHandler implements RecordHandler<Customer> {
   public Customer parse(String[] fields) {
      return new Customer(fields[0], fields[1]);
   }
}

class ItemHandler implements RecordHandler<Item> {
   //...
}

Set<Item> items = new CVSParser<Item>(new ItemHandler()).parse(itemsFile);