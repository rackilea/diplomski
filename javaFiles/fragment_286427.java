public class ContainsDescription extends Attachments
{
    private String description;

    public ContainsDescription(String description, String filename, int kilobytes)
    {
        super(filename, kilobytes);
        this.description = description;          
    }
}