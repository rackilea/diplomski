@Data // Generate all setter and getter.
public class UserSearchCondition implements ISearchCondition
{
    private String enabled = null;

    public Boolean isEnabled()
    {
        if (Strings.isNullOrEmpty(enabled) || enabled.toLowerCase().equals("null"))
            return null;
        return Boolean.valueOf(enabled);
    }
}