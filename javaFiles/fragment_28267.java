@Data
@EqualsAndHashCode(callSuper = true)
public class ExtendedQuery extends SimpleQuery {
    private List<String> queryFields;
    private String defaultField;
}