private static volatile MySingletonExample instance = new MySingletonExample();

private final boolean myBoolean1;
private final boolean myBoolean2;

private MySingletonExample()
{
    myBoolean1 = true;
    myBoolean2 = true;
}

//...