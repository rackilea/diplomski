ModelMapper mapper = new ModelMapper();

Converter<Set<Child>, int[]> childSetToIntArrayConverter =
        ctx -> ctx.getSource()
                .stream()
                .mapToInt(Child::getId)
                .toArray();

mapper.createTypeMap(Parent.class, ParentDto.class)
        .addMappings(map -> map
                .using(childSetToIntArrayConverter)
                .map(
                        Parent::getChildren,
                        ParentDto::setChildren
                )
        );