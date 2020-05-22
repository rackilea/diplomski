public class GrandParent
{
    public String f() {
        return "grand parent";
    }
}

public class Parent extends GrandParent
{
    @Override public String f() {
        return "parent";
    }
}

public class Son extends Parent
{
    @Override public String f() {
        return "son";
    }
}

public class Test
{
    public static void main(String[] args) {
        GrandParent p = new Son();
        System.out.println(p.f());
    }
}