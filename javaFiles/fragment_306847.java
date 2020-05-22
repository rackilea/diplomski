@Override
public int hashCode()
{
    return name == null ? 0 : name.hashCode();
}

@Override
public boolean equals(final Object obj)
{
    if (obj == null)
        return false;
    if (this == obj)
        return false;
    if (!(obj instanceof Employee))
        return false;
    final Employee other = (Employee) obj;
    return name == null ? other.name == null
        : name.equals(other.name);
}