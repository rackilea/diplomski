package de.mosst.spielwiese;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.ReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;

import lombok.Data;

public class XStreamMultiClassesTest {

    @Test
    public void smokeTest() {
        InputStream file = XStreamMultiClassesTest.class.getResourceAsStream("XStreamMultiClassesTest.xml");
        XStream xStream = new XStream();
        xStream.ignoreUnknownElements();
        xStream.processAnnotations(Mission.class);
        xStream.processAnnotations(Alternative.class);

        Converter converter = new AlternativeConverter(xStream.getMapper(), xStream.getReflectionProvider());
        xStream.registerConverter(converter);

        Mission mission = (Mission) xStream.fromXML(file);

        System.out.println(mission);
        mission.branch.forEach(a -> {
            System.out.println(a.getClass());
            if (a instanceof AlternativeA) {
                System.out.println("- condition: " + ((AlternativeA) a).condition);
            }
        });
    }

    public class AlternativeConverter extends ReflectionConverter {

        public AlternativeConverter(Mapper mapper, ReflectionProvider reflectionProvider) {
            super(mapper, reflectionProvider);
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            Alternative alternative = null;
            if (reader.getAttribute("condition") != null) {
                alternative = new AlternativeA();
                ((AlternativeA) alternative).condition = reader.getAttribute("condition");
            } else {
                alternative = new AlternativeB();
            }
            alternative.uid = Integer.parseInt(reader.getAttribute("uid"));
            return super.doUnmarshal(alternative, reader, context);
        }

        @Override
        public boolean canConvert(@SuppressWarnings("rawtypes") Class clazz) {
            return Alternative.class.isAssignableFrom(clazz);
        }
    }

    @XStreamAlias("mission")
    @Data
    class Mission {
        public List<Alternative> branch = new ArrayList<>();
    }

    @XStreamAlias("alternative")
    @Data
    abstract class Alternative {
        @XStreamAsAttribute
        public int uid;
        @XStreamAsAttribute
        public String type;
    }

    class AlternativeA extends Alternative {
        public String condition;
    }

    class AlternativeB extends Alternative {
    }

}