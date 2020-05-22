@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, 
      include=JsonTypeInfo.As.PROPERTY, property="@type")
class Execution {
...
}

objectMapper.registerSubtypes(
            new NamedType(Execution.class, "Execution"), // the same name
    ....
);
objectMapper.readValue(....); // will be deserialized to an Execution instance