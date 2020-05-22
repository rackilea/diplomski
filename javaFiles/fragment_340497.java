import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class XmlMapperApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.xml").getAbsoluteFile();

        JavaTimeModule module = new JavaTimeModule();
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(module);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Dataset dataset = xmlMapper.readValue(jsonFile, Dataset.class);
        dataset.getElements().forEach(System.out::println);
    }
}