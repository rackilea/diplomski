public class DefaultPolyLine implements PolyLine
{
    private Line line;
    private Arc arc;

    public DefaultPolyLine(Line line, Arc arc)
    {
        this.line = line;
        this.arc = arc;
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