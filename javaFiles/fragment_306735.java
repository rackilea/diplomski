import java.util.*;

public class Node
{
    private String violationType;
    private String dataInside;

    public Node()
    {   
        this("", "");
    }
    public Node(String violationType)
    {
        this(violationType, "");
    }
    public Node(String violationType, String dataInside)
    {
        this.violationType = violationType;
        this.dataInside = dataInside;
    }
    public void setViolationType(String violationType)
    {
        this.violationType = violationType;
    }
    public void setDataInside(String dataInside)
    {
        this.dataInside = dataInside;
    }
    public String getViolationType()
    {
        return violationType;
    }
    public String getDataInside()
    {
        return dataInside;
    }
}