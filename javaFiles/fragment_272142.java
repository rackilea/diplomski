class EmployeeRecord implements Record
{
    String name;

    EmployeeRecord( String name )
    {
       this.name = name;
    }

    @Override
    public void print()
    {
        System.out.println( name );
    }
}