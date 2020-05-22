public <T extends Component> T getComponentByType(Class<T> type)
{
    for(Component component : componentList)
    {
        if(component.getClass() == type)
        {
            return (T)component;
        }
    }
    return null;
}