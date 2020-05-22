public class MyModel extends Model {

    @Constraints.MaxLength(value = 4, message = "validation.limit")
    @Constraints.Required
    @Column(name = "column_name")
    public String columnName;
}