package com.example.jackson;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JacksonDeserializerOfNamedTypes extends StdDeserializer<Object> {
    private final Map<String, Class<?>> typesByName;
    private final String typeProperty;

    private JacksonDeserializerOfNamedTypes(final Map<String, Class<?>> typesByName, final String typeProperty) {
        super(Object.class);

        this.typesByName = typesByName;
        this.typeProperty = typeProperty;
    }

    @Override
    public Object deserialize(final JsonParser parser, final DeserializationContext context) throws IOException, JsonProcessingException {
        final ObjectCodec codec = parser.getCodec();
        final JsonNode root = parser.readValueAsTree();
        final JsonNode typeNameNodeOrNull = root.get(typeProperty);
        if (typeNameNodeOrNull == null) {
            throw new JsonMappingException(parser, "Unable to determine Java type of JSON: " + root);
        } else {
            final String typeName = typeNameNodeOrNull.asText();
            return Optional
                .ofNullable(typesByName.get(typeName))
                .map(type -> parseOrNull(root, type, codec))
                .orElseThrow(() ->
                    new JsonMappingException(parser, String.format(
                        "Unsupported type name '%s' in JSON: %s", typeName, root)));
        }
    }

    private <T> T parseOrNull(final JsonNode root, final Class<T> type, final ObjectCodec codec) {
        try {
            return root.traverse(codec).readValueAs(type);
        } catch (IOException e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        final Map<String, Class<?>> typesByName = scanForNamedTypes();

        final SimpleModule namedTypesModule = new SimpleModule("my-named-types-module");
        namedTypesModule.addDeserializer(Object.class, new JacksonDeserializerOfNamedTypes(typesByName, JsonTypeInfo.Id.NAME.getDefaultPropertyName()));

        final Car pinto = new Car("Ford", "Pinto", 1971);
        final Balloon sharik = new Balloon("blue");
        final ObjectMapper mapper = new ObjectMapper().registerModule(namedTypesModule);
        System.out.println(mapper.readValue(mapper.writeValueAsString(pinto), Object.class).getClass());
        System.out.println(mapper.readValue(mapper.writeValueAsString(sharik), Object.class).getClass());
    }

    @JsonTypeName("Balloon")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    public static final class Balloon {
        public String color;

        private Balloon() {}

        public Balloon(final String color) {
            this.color = color;
        }
    }

    @JsonTypeName("Car")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    public static final class Car {
        public String make;
        public String model;
        public int year;

        private Car() {}

        public Car(final String make, final String model, final int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
    }

    static Map<String, Class<?>> scanForNamedTypes() {
        //in reality, i'd be using a framework (e.g. Reflections) to scan the classpath
        //for classes tagged with @JsonTypeName to avoid maintaining manual mappings
        final Map<String, Class<?>> typesByName = new HashMap<>();
        typesByName.put("Balloon", Balloon.class);
        typesByName.put("Car", Car.class);
        return Collections.unmodifiableMap(typesByName);
    }
}