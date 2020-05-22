//...
import static org.apache.felix.scr.annotations.ReferenceCardinality.MANDATORY_UNARY;
import static org.apache.felix.scr.annotations.ReferencePolicy.DYNAMIC;

//...
@Component
public class Consumer
{
    @Reference(policy = DYNAMIC, cardinality = MANDATORY_UNARY)
    private Producer producer;

    public void unbindProducer() {
        System.out.println("Producer unbound.");
        this.producer = null;
    }
//...
}