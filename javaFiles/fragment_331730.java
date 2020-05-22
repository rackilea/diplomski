public interface PolyLine extends Line, Arc
{

}

public class DefaultPolyLine implements PolyLine
{
    private Line line;
    private Arc arc;

    public DefaultPolyLine()
    {
        line = new DefaultLine();
        arc = new DefaultArc();
    }

    public void lineMethod()
    {
        line.lineMethod();
    }

    public void arcMethod()
    {
        arc.arcMethod();
    }
}