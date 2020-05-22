public static class StaticParent 
{
    public static void commonMethod(){          
        System.out.println(getOutput());
    }

    public static String getOutput(){
        return "Parent";
    }
}

public static class StaticChildA extends StaticParent
{
    public static String getOutput(){
        return "ChildA";
    }
}

public static class StaticChildB extends StaticParent
{
    public static String getOutput(){
        return "ChildB";
    }
}