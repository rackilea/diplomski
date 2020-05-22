public final CoreClass
{
    …
    public final AnInterface createAnInterfaceInstance( Supplier<AnInterface> factory )
    { return factory.get(); }
}