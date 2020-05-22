@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, 
      include=JsonTypeInfo.As.PROPERTY, property="@type")
class Prototype {
...
}

objectMapper.registerSubtypes(
            new NamedType(Prototype.class, "Execution"),
            ...
);