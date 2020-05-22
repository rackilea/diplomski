@Component
public class MyListener implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private TcpInboundGateway gate;

    @Autowired
    private IntegrationMBeanExporter bean;

    @Override
    public void onApplicationEvent(ContextClosedEvent e) {
        //return
        int actives = gate.beforeShutdown();

            if (actives == 0) {
                bean.stopActiveComponents(true, 0);
            } else {
                bean.stopActiveComponents(false, timeout);
            }
    }
}