@org.simpleframework.xml.Root
public class Root{
    @Element
    Children children;

    public Root(){
        children = new Children("Something");
    }
}

@org.simpleframework.xml.Root
public class Children{
    @Element
    String innerChildren;

    public Children(String inner){
        innerChildren = inner;
    }
}