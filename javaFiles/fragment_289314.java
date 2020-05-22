@SqlResultSetMapping(name = "CustomMapping",
        classes = {
                @ConstructorResult(targetClass = CustomPOJO.class,
                        columns = {@ColumnResult(name = "id", type = Long.class),
                                @ColumnResult(name = "data", type = MyJsonType.class),
                                @ColumnResult(name = "price", type = BigDecimal.class)})
        })