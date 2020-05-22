private final static int MAX_RETRIES = 5;

@HystrixCommand(fallbackMethod = "defaultInvokcation")
public String getRemoteBro(String name) {
    return(executeRemoteService(name));
}

private String executeRemoteService(String serviceName) {
    for (int i = 0; i < MAX_RETRIES; i++) {
        try {
            return reallyExecuteRemoteService(serviceName);
        } catch (ServiceException se) { 
          // handle or log execption
        }
    }
    throw new RuntimeException("bam");
}