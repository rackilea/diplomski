package mypackage;
import org.apache.velocity.app.event.ReferenceInsertionEventHandler;

public class MyHandler implements ReferenceInsertionEventHandler
{
    public Object referenceInsert( String reference, Object value  )
    {
        // ...notify user...
    }
}