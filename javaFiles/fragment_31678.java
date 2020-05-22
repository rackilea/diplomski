public class ResourceAwareMyDataSource extends AbstractRoutingDataSource {

    private static final Logger logger = LoggerFactory.getLogger(ResourceAwareMyDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {

        try {
            //Check whether the primary DB is active 
            if(primaryIsActive()) {
                return "Primary"
            }
        } catch (Exception e) {
            logger.error("Error occurred when checking  primary",e);
            logger.info("Switching back to Secondary..");
            return "Secondary";
        }
        //Primary is inactive
        logger.info("Primary is Inactive, Switching back to Secondary");
        return "Secondary";
    }
}