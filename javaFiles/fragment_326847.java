@Override
public final boolean equals(final Object obj)
{
    if (obj == null)
        return false;
    if (this == obj)
        return true;
    // Class<?> are signletons, therefore we can use ==/!=
    if (getClass() != obj.getClass())
        return false;
    return name.equals(((Foo) obj).name);
}