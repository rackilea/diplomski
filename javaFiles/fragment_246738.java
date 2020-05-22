public class JBPMDeploymentService extends BatchService {

            /**
             *  Logger for Batch service
             */
            protected static final Logger log = Logger.getLogger(NAPSJBPMDeploymentService.class);

            private Map<String, String> jpdlMap = new HashMap<String, String>();

            private Map<String, String> procInstMap = new HashMap<String, String> ();

            public void doService() throws NAPSBatchException
            {
                log.info("Entering into doService Method of JBPMDeploymentService ...");
                String approvalFlow = getJpdlFileType();

                String jpdlXML = getJPDLxml(approvalFlow);

                String procInst = getProcessInstanceKey(approvalFlow);

                // constructs the ProcessEngine
                ProcessEngine processEngine = new Configuration().setResource("naps.jbpm.cfg.xml").buildProcessEngine();

                // retrieve the needed services
                RepositoryService repositoryService = processEngine.getRepositoryService();
                ExecutionService executionService = processEngine.getExecutionService();



                repositoryService.createDeployment()
                .addResourceFromClasspath(jpdlXML)
                .deploy();
                //executionService.startProcessInstanceByKey(procInst);

            }

    /**
         * @return the jpdlMap
         */
        public Map<String, String> getJpdlMap() {
            return jpdlMap;
        }

        /**
         * @param jpdlMap the jpdlMap to set
         */
        public void setJpdlMap(Map<String, String> jpdlMap) {
            this.jpdlMap = jpdlMap;
        }

        /**
         * @param jpdlKey
         * @return jpdl xml name
         */
        private String getJPDLxml(String jpdlKey)
        {
            return jpdlMap.get(jpdlKey);
        }

        /**
         * @return the procInstMap
         */
        public Map<String, String> getProcInstMap() {
            return procInstMap;
        }

        /**
         * @param procInstMap the procInstMap to set
         */
        public void setProcInstMap(Map<String, String> procInstMap) {
            this.procInstMap = procInstMap;
        }

        /**
         * @param procInstKey
         * @return process Instance key
         */
        private String getProcessInstanceKey(String procInstKey){
            return this.procInstMap.get(procInstKey);
        }
}