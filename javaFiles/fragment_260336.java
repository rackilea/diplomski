public <T extends GameComponent<?>> T getComponentOfType(Class<T> classDude)
{
    for(GameComponent<?> gC : components)
    {
        if(classDude.isInstance(gC))
        {
            return classDude.cast(gC);
        }
    }
    return null;
}