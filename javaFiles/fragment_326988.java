import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.google.common.collect.ImmutableMap;

import akka.actor.AbstractActor;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

public class BaseActor extends AbstractActor {

    private final Logger log = LoggerFactory.getLogger(BaseActor.class);

    @Override
    public void aroundReceive(PartialFunction<Object, BoxedUnit> receive, Object msg) {
        if (msg instanceof IdMessage) {
            final Map<String, Object> originalMDC = log.getMDC();
            MDC.setContextMap(ImmutableMap.of("id", ((IdMessage) msg).getId()));
            try {
                super.aroundReceive(receive, msg);
            } finally {
                if (originalMDC != null) {
                    MDC.setContextMap(originalMDC);
                } else {
                    MDC.clear();
                }
            }
        } else {
            super.aroundReceive(receive, msg);
        }
    }
}