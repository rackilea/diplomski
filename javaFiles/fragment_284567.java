public class TestStatic
{
public static int x =10;
}

public class YourClass
{

public void yourMethod()
{
int yourVar = TestStatic.x;
}
}