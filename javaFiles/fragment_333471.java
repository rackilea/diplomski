@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({"name", "seq", "height"})
public class EmployeeAttribute
{

    public String name;

    public int seq;

    public int height;

    @Override
    public String toString()
    {
        return "EmployeeAttribute [name=" + name + ", seq=" + seq + ", height=" + height + "]";
    }
}