void CSharpMethod(int i, Foo f, ref int j, ref Bar b)
{
    i = 9; //not changed from caller's point of view
    f = new Foo(); //not changed from caller's point of view

    j = 9; //changed from caller's point of view
    b = new Bar(); //changed from caller's point of view
}