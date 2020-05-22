import java.lang.reflect.*;
import java.util.*;

public class Dispatcher
{
    // the map associates xml msg type to processor type  
    private static Map<Class<?>, Class<?>> dispatchMap = new HashMap<>();

    static
    {
        dispatchMap.put(AccessCheck.class, AuthorizationDataFacade.class);
        dispatchMap.put(Login.class, AuthorizationDataFacade.class);
        dispatchMap.put(Note.class, SomeOtherDataFacade.class);
    }

    public String dispatch(Object obj)
    {
        Class<?> xmlMsgType = obj.getClass();
        // search for xml msg type in dispatch map
        if (!dispatchMap.containsKey(xmlMsgType)) {
            return "unrecognized message type";
        }
        // found match, now locate process method
        try {
            Class<?> ProcessorType = dispatchMap.get(xmlMsgType);
            Method[] processorTypeMethods = ProcessorType.getDeclaredMethods();
            Method chosenProcssMethod = 
                Arrays.stream(processorTypeMethods)
                    .filter(m -> methodFitForXmlMsg(m, xmlMsgType))
                    .findFirst()
                    .orElse(null);
            if (chosenProcssMethod != null) {
                // found match, instantiate processor and invoke method 
                Object processorInstance = ProcessorType.newInstance();
                return (String)chosenProcssMethod.invoke(
                        processorInstance, 
                        chosenProcssMethod.getParameterTypes()[0].cast(obj));
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        // no match found or error 
        return "error";
    }

    // a method is dimmed fit for processing a given xml msg type
    // if it is named "process", returns a String, has one arg that is of the given type 
    private boolean methodFitForXmlMsg(Method m, Class<?> xmlMsgType)
    {
        return m.getName().equals("process")  &&
                m.getReturnType() == String.class  && 
                m.getParameterCount() == 1  &&
                m.getParameterTypes()[0].equals(xmlMsgType);
    }

    public static void main(String... args)
    {
        Dispatcher d = new Dispatcher();

        System.out.println(d.dispatch(new AccessCheck()));
        System.out.println(d.dispatch(new Login()));
        System.out.println(d.dispatch(new Note()));
        System.out.println(d.dispatch("something else"));
    }
}