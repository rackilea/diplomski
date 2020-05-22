public GameComponent<?> getComponentOfType(Class<?> classDude)
{
    for(GameComponent<?> gC : components)
    {
        if(classDude.isInstance(gC))
        {
            return (GameComponent<?>) classDude.cast(gC);
        }
    }
    return null;
}