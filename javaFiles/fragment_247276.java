import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class BasicConverter implements Converter {

    @Override
    public boolean canConvert(Class type) {
        return Test.class.isAssignableFrom(type);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer,
            MarshallingContext context) {
        if (((Test) source).item instanceof Item1) {
            writer.startNode("Item1");
            writer.addAttribute("description", ((Item1)((Test) source).item).description);
        } else if (((Test) source).item instanceof Item2) {
            writer.startNode("Item2");
            writer.addAttribute("description", ((Item2)((Test) source).item).description);
        }
        writer.addAttribute("name", ((Test) source).item.name);
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader,
            UnmarshallingContext context) {
        Test test = new Test();

        reader.moveDown();
        String nodeName = reader.getNodeName();
        AbstractItem item = null;       
        if (nodeName.equals("Item1")) {
            item = new Item1();
            ((Item1)item).description = reader.getAttribute("description");
        } else if (nodeName.equals("Item2")) {
            item = new Item2();
            ((Item2)item).description = reader.getAttribute("description");
        }   
        item.name = reader.getAttribute("name");    
        ((Test)test).item = item;
        reader.moveUp();
        return test;
    }
}