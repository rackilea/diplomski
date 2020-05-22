public interface HierarchyMapper<T> {
    @SelectProvider(method = "buildGetByName", type = HierarchySqlBuilder.class)
    @Results(id = "workerResult", value = {
              @Result(property = "id", column = "id", id = true),
              @Result(property = "name", column = "name")
            })
    @TypeDiscriminator(cases = {
            @Case(type = Actor.class, value = "actor"),
            @Case(type = Writer.class, value = "writer")},
            column = "worker_type")
    T getByName(@Param("name") String name, @Param("table") String table);
}

@Mapper
public interface ActorMapper extends HierarchyMapper<Actor> {
}

public class HierarchySqlBuilder {
  public static String buildGetByName(
          @Param("name") String name, @Param("table") String table) {
        return String.format(
                "SELECT '%s' as worker_type, id, name from %s where name = #{name}", table, table);
      }
}