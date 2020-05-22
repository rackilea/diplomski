public class BeeDetails
{
    public string details { get; set; }

}

public class Bee
{
    public BeeDetails { get; set; }
}

public class BeeResponse
{
    public List<Bee> Bees { get; set; }
}