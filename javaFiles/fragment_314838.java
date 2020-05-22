public class ParseStringList extends CellProcessorAdaptor {

        public ParseStringList() {
                super();
        }

        public Object execute(Object value, CsvContext context) {
                validateInputNotNull(value, context);  // throws an Exception if the input is null
                List<String> result = new ArrayList<String>();
                result.add((String) object);
                return result;
        }
}