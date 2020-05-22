/**
 * Change the path of log file
 * @param path new path
 */
public synchronized void changeLogPath(String path) {
      String filename = (path.endsWith(File.separator)) ? path : path + File.separator;
      filename += LOGFILENAME + "-{timestamp}.log";

      props.setProperty("log4j.appender.A1","org.pollerosoftware.log4j.additions.appenders.TimestampFileAppender");
      props.setProperty("log4j.appender.A1.TimestampPattern","ddMMyyyy");
      props.setProperty("log4j.appender.A1.File",filename);
      LogManager.resetConfiguration();
      PropertyConfigurator.configure(props);
}