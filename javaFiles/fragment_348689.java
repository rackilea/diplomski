package test;

import java.text.MessageFormat;
import java.util.Map;

import org.apache.synapse.config.xml.MediatorFactoryFinder;
import org.apache.synapse.config.xml.MediatorSerializer;
import org.apache.synapse.config.xml.MediatorSerializerFinder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import test.synapse.mediator.TestMediator;
import test.synapse.mediator.TestMediatorFactory;
import test.synapse.mediator.TestMediatorSerializer;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        {
            Map<javax.xml.namespace.QName, java.lang.Class> mediatorFactoryMap = MediatorFactoryFinder.getInstance().getFactoryMap();
            mediatorFactoryMap.put(TestMediatorFactory.QNAME, TestMediatorFactory.class);
        }
        {
            Map<String, MediatorSerializer> mediatorSerializerMap = MediatorSerializerFinder.getInstance().getSerializerMap();
            mediatorSerializerMap.put(TestMediator.class.getName(), TestMediatorSerializer.class.newInstance());
        }
    }

    public void stop(BundleContext context) throws Exception {
        // Maybe undo what was done in the start(BundleContext) method..?
        System.out.println(this.getClass().getName() + ".stop(BundleContext) called");
    }
}