import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class MyClassConverter implements Converter{

    @Override
    public boolean canConvert(Class clazz) 
    {
        return clazz.equals(MyClass.class);
    }

    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer,
            MarshallingContext context) 
    {

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader,
            UnmarshallingContext context) 
    {
        // Create MyClass Object
        MyClass myClass = new MyClass();

        // Traverse Tree
        while (reader.hasMoreChildren()) 
        {
            reader.moveDown();
            if ("polygon".equals(reader.getNodeName())) 
            {
                Polygon polygon = (Polygon)context.convertAnother(myClass, Polygon.class);
                myClass.addPolygon(polygon);
            } 
            reader.moveUp();
        }

        // Return MyClass Object
        return myClass;
    }
}