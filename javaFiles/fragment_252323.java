import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<MyFrame> myFrameList = new ArrayList<MyFrame>();
        myFrameList.add(new A());
        myFrameList.add(new B());
        foo(myFrameList,A.class);


    }
    public static void foo(List<MyFrame> myFrameList, Class c)
    {
         for(MyFrame f:myFrameList)
        {
            if(c.isInstance(f))
            {
                f.update();
            }
        }
    }
}

abstract class MyFrame
{
     public abstract void update();
}
class A extends MyFrame
{

    @Override
    public void update() {
        System.out.println("Aaaaa");
    }

}

class B extends MyFrame
{

    @Override
    public void update() {
        System.out.println("Bbbb");
    }

}