String s = null;
foo( s );
assert s == null;

void foo( String s )
{
    s = "not null";
}