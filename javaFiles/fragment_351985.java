public interface Interface {

      void action();
} 

public class ClassOne implements Interface {

    @Override
    public void action(){
        System.out.println("class one action");
    }
}

public class ClassTwo implements Interface {

    @Override
    public void action(){
        System.out.println("class two action");
    }
}

public class ClassThree implements Interface {

    @Override
    public void action(){
        System.out.println("class three action");
    }
}