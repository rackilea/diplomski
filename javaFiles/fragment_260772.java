public void startService(int serviceId, String serviceName, String 
ipAddress) {
CMDExecutor executor = new CMDExecutor();
try {
String credentialsCommand = "cmd /C echo "+ password +" runas /user:"+ username;
String startServiceCommand = "sc\\\\"  +ipAddress+ " start "+ serviceName";
String credentialsResult = executor.getCMDResult(credentialsCommand );
logger.info(credentialsResult );
String startServiceResult= executor.getCMDResult(startServiceCommand );
logger.info(startServiceResult);
}