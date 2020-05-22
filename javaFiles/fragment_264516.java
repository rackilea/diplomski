public interface DaoMapper {

  @Select({
      "SELECT col1, col2, col3",
        "FROM my_table" })
  @Results(value = {
      @Result(column = "col1", property = "col1", typeHandler = EmptyStringTypeHandler.class),
      @Result(column = "col2", property = "col2", typeHandler = EmptyStringTypeHandler.class),
      @Result(column = "col3", property = "col3", typeHandler = EmptyStringTypeHandler.class)
  })
  List<LinkedHashMap<String, ?>> getUntyped();

}