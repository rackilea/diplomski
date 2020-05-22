public Employee findEmail( String email )
{
    for( Employee e : map.values() )
    {
        if( email.equals( e.getEmail() ) )
            return e;
    }
    return null;
}