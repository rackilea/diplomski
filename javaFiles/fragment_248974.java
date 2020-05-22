public class BadExampleContextState implements ContextState<Integer, String>{
    @Override
    public String updateWithContext(Integer context)
    {
        return "Garbage";
    }

    @Override
    public String update()
    {
        return "Garbage";
    }
}