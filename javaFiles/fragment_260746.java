// compares property set using a delegate
public ComplexRule : IFactoryRule
{
    private readonly Func<PropertySet, bool> _func;
    public ComplexRule(func) { ... }

    public bool CanInstantiate(PropertySet propSet)
    {
        return _func(propSet);
    }
}