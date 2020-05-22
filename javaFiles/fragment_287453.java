public class MyBridge implements FieldBridge {
    public void set(String name, Object value, Document document, LuceneOptions luceneOptions) {
        if (value instanceof List){
            for(Object myInt:(List)value){
                Field myIntField = new Field(name, myInt.toString(), luceneOptions.getStore(), luceneOptions.getIndex(), luceneOptions.getTermVector());
                myIntField.setBoost(luceneOptions.getBoost());
                document.add(myIntField);
            }
        }
    }
}