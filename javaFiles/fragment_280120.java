public class Basic
{
    public static void moveLeft(Component component, int offset)
    {
        component.setLocation(component.getX() - offset, component.getY());
    }
}