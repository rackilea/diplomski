@Override
public boolean equals(Object other)
{
    if (!(other instanceof Person))
        return false;
    Person p = (Person) other;
    return p.name.equals(this.name);
}