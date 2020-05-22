for(Control control : shell.getChildren())
{
    UUID id = (UUID) control.getData();

    if(id.equals(WHATEVER_HERE))
    {
        System.out.println(control);
    }
}