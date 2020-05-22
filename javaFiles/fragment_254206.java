package myPackage;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

public class MyInterfaceConverter extends ReflectionConverter {

    public MyInterfaceConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
        super(mapper, reflectionProvider);
    }

    @Override
    public void marshal(Object original, final HierarchicalStreamWriter writer, final MarshallingContext context) {
        writer.addAttribute("class", original.getClass().getCanonicalName());
        super.marshal(original, writer, context);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean canConvert(Class type) {
        return MyInterface.class.isAssignableFrom(type);
    }

}