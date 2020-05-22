public interface Property<U extends Unit> {

    public void setUnit(U unit );    // for example
}

public class Force implements Property<ForceUnit> {
    @Override
    public void setUnit(ForceUnit unit) { }
}

public class Mass implements Property<MassUnit> {
    @Override
    public void setUnit(MassUnit unit) { }
}