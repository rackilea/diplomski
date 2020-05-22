public class ParamConverter implements Converter{

    boolean canConvert(Class type){
        return Param.class.equals(type);
    }

    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context){
        Param param = (Param)source;
        if (NAME_TO_SKIP.equals(param.getName()){
            return;
        }
        // delegate to ReflectionConverter or something else appropriate.
    }   
}