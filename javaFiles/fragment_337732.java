import java.lang.reflect.*;
import java.util.*;

public class UploadBean {

    // "throws Exception" just for simplicity. Not nice normally!
    public static void main(String[] args) throws Exception {
        Class<?> parTypes[] = new Class<?>[1];
        parTypes[0] = Map.class;
        Constructor ct = UploadBean.class.getDeclaredConstructor(parTypes);
        Object[] argList  = new Object[1];
        argList[0] = null;
        Object retObj = ct.newInstance(argList);
    }

    protected UploadBean(Map<String,?> map){ 
        //do nothing.
    }
}