public aspect InterceptTimer
{
    // where TimerMock extends Timer
    TimerTask around(): call(TimerTask+.new()) && !within(InterceptTimer)
    {
        return new TimerMock();
    }  
}