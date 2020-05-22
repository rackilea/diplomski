import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.util.ReflectionUtils;

public class Test {

    public static void main(String[] args) {
        System.out.println(getReturnTypeName("getList"));
        System.out.println(getReturnTypeName("getListList"));
        System.out.println(getReturnTypeName("getObj"));
        System.out.println(getReturnTypeName("getMapMap"));
    }

    private static String getReturnTypeName(String method) {
        Type returnType = ReflectionUtils.findMethod(Test.class, method).getGenericReturnType();

        return new TypeSimpleName(returnType).getName();
    }

    public List<String> getList() {
        return null;
    }

    public List<List<String>> getListList() {
        return null;
    }

    public Integer getObj() {
        return 1;
    }

    public Map<String, Map<Integer, BigDecimal>> getMapMap() {
        return null;
    }
}