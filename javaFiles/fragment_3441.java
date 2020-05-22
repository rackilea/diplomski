Summariser summer = null;
String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");//$NON-NLS-1$
if (summariserName.length() > 0) {
    summer = new Summariser(summariserName);
}

String logFile = "/path/to/output/file.jtl";
ResultCollector logger = new ResultCollector(summer);
logger.setFilename(logFile);
testPlanTree.add(testPlanTree.getArray()[0], logger);