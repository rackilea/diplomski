@Override
public boolean equals(Object person)
{
    boolean same = false;

    if (person != null && person instanceof Person)
    {
        same = this.name == ((Person) person).name;
    }

    return same;
}