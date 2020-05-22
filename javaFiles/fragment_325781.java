class Test
{
void go()
{
    foo("first", "second", "third", new String []{"hello", "world"});

}
 void foo(String first, final String second, final String third, final String... headers) {}

}