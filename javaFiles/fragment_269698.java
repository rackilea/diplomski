public Object clone ()
{
    MyClass other = new MyClass ();
    other.somePrivateMember = this.somePrivateMember;
    ...
    return other;
}