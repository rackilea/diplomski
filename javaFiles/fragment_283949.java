public aspect InterceptTimer
{
    // where TimerMock extends Timer
    Timer around(): call(Timer.new())
    {
         return new TimerMock();
    }
}

public class Test {

    public void method() 
    {
        Timer a = new Timer();
        System.out.println(a.toString());
    }
}