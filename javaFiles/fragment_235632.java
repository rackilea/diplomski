public Object makeThing( final String name )
{
    return new Object()
        {
            @Override
            public String toString(){
                return name; // Won't work if `name` is not `final`.
            }
        };
}