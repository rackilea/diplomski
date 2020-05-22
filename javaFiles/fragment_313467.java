@Entity @IdClass(IdTypeCompoundId.class)
public class IdType implements Serializable
{
    /**
     * User specified Unique identifier.
     * Both idTypeCode and idCategory are together
     * a compound key, so as to ensure that the 
     * combination of the both can not occur more
     * than once in the table.
     */
    @Id
    public String idTypeCode;
    @Id
    public IdCategory idCategory;

    public String idTypeName;
}


public class IdTypeCompoundId implements Serializable
{
    public String idTypeCode;

    public IdCategory idCategory;
}