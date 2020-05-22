public interface ChildInterface{

    ...
}

public interface Interface extends ChildInterface{

    //add methods you don't want Children to have
}


public class XYZ implements Interface{
   ...
}