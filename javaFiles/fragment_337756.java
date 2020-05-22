public class SimpleXMLStringConverter implements Converter<String> {


    @Override
    public String read(InputNode node) throws Exception {
        String value = node.getValue();
        if(value == null) {
            value = "";
        }
        return value;
    } 

    @Override
    public void write(OutputNode node, String value) throws Exception {
        node.setValue(value);
    }

}