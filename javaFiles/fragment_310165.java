public interface IFactory
{
    object createInstance;
}

public class ClassWithDependencyOnFactory
{
     private IFactory factory;
     public ClassWithDependencyOnFactory(IFactory factory)
     {
        this.factory = factory;
     }

     public void DoSomething()
     {
         var thing = factory.createInstance();
         ...
     }
}