// At the top of everything
import java.util.concurrent.atomic.AtomicLong;  

...    

// In PoolDemo
static AtomicLong TotalTime = new AtomicLong();    

...    

// In Task, where you currently do the TotalTime += piece
TotalTime.addAndGet (Duration);