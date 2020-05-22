import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper baseMapper = new ObjectMapper();
        baseMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        baseMapper.setAnnotationIntrospector(new ClassIgnoranceIntrospector(PointlessBase.class));

        ObjectMapper extendedMapper = new ObjectMapper();
        extendedMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        extendedMapper.setAnnotationIntrospector(new ClassIgnoranceIntrospector(PointlessExample.class));

        List<PointlessBase> list = Arrays.asList(new PointlessBase(), new PointlessExample());
        for (PointlessBase item : list) {
            System.out.println("Base only mapper for class " + item.getClass().getSimpleName() + " " + baseMapper.writeValueAsString(item));
            System.out.println("Extended only mapper for class " + item.getClass().getSimpleName() + " " + extendedMapper.writeValueAsString(item));
        }
    }
}