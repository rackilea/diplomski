@Service
public class MdspiImpl extends CThostFtdcMdSpi {

    @Autowired
    private SpringContextUtil springContextUtil;

    public MdspiImpl(CThostFtdcMdApi mdapi) {
        m_mdapi = mdapi;
        logger.info("MdspiImpl is creating...");
        ***mdr = springContextUtil.getBean("marketDataRobot");
    }
}