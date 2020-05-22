public class Entity
{
    private ArrayList<Component> _components;

    ...

    public void addComponent(Component c)
    {
        _components.add(c);
        c.Enable();
    }

    public Component getComponent(Class componentClass)
    {
        for (Component c : _components)
        {           
            if (c.getClass() == componentClass)
                return c;
        }

        return null;
    }
}