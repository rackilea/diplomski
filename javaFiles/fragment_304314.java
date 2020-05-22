import java.lang.management.ThreadMXBean;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Gen {

    public static void main(String[] args) {
        List<Class> intfc = new ArrayList<Class>();
        intfc.add(ThreadMXBean.class);
        for(Class c:intfc)
            System.out.println(gen(c));
    }

    private static String gen(Class c) {
        StringBuilder sb = new StringBuilder();
        sb.append("return new MBeanInfo(\"");
        sb.append(c.getName());
        sb.append("\",");
        sb.append("\n\"Desc\",\r\n" + 
                "               null,null, \r\n" + 
                "               new MBeanOperationInfo[]{");
        boolean first = true;
        for(Method m:c.getDeclaredMethods()){
            if(!first)
                sb.append(",");
            first = false;
            sb.append("\nnew MBeanOperationInfo(");
            sb.append("\""+m.getName()+"\",\""+m.getName()+"\", new MBeanParameterInfo[]{");
            boolean firstparam = true;
            for(Class param:m.getParameterTypes()){
                if(!firstparam)
                    sb.append(",");
                firstparam = false;
                sb.append("new MBeanParameterInfo(\"ParamName\",\"");
                sb.append(param.getName()).append("\",");
                sb.append("\"Description\")");
            }
            sb.append("},\""+m.getReturnType().getName()+"\",0)");
            sb.append("\n");
        }

        sb.append("}\n,null);");
        return sb.toString();
    }
}