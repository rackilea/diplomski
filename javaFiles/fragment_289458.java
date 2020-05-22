Entity entityToTransform = new Entity();
    EntityDTO entityDtoToTransform = new EntityDTO();

    // Entity -> EntityDTO
    // transform the list of KeyValues to KeyValueDTOs
    List<KeyValueDTO> keyValueDtos = entityToTransform.getValues().stream(
    ).flatMap(
        keyValue -> Arrays.stream(
            keyValue.getValues()
        ).map(
            value -> new KeyValueDTO(keyValue.getKey(), value)
        )
    ).collect(Collectors.toList());
    // set the object
    EntityDTO entityDto = new EntityDTO(keyValueDtos);


    // EntityDTO -> Entity
    // transforms the list of KeyValueDTOs to KeyValues
    List<KeyValue> keyValues = entityDtoToTransform.getValues().stream(
    ).collect(
        Collectors.collectingAndThen(
            Collectors.groupingBy(keyValueDto -> keyValueDto.getKey()),
            groupings -> groupings.entrySet().stream(
            ).map(
                entry -> new KeyValue(
                    entry.getKey(),
                    entry.getValue().stream(
                    ).map(
                        keyValueDto -> keyValueDto.getValue()
                    ).collect(
                        Collectors.toList()
                    ).toArray(
                        new Object[entry.getValue().size()]
                    )
                )
            ).collect(Collectors.toList())
        )
    );

    Entity entity = new Entity(keyValues);