@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Identifiable
{
    public int value;

    public Identifiable next;
}