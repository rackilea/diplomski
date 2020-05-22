public final class EmployeeComp
    implements Comparator<Employee>
{
    @Override
    public int compare(final Employee o1, final Employee o2)
    {
        final int id1 = o1.getId(), id2 = o2.getId();
        if (id1 == id2)
            return 0;
        return id1 > id2 ? 1 : -1;
    }
}