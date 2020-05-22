import org.apache.log4j.Logger;
public class MyCallingClass {

    final static Logger logger = Logger.getLogger(this.getClass());

    //Determine the active enviourment,You may determine this from os environment variable if you want
    String activeEnvironment = MyPropertyUtil.
            getValuesFromPerpertyFile("resource/active_env.properties"
                    ,"profiles.active");

    //Set the property file
    String myEnvSpecificValue = MyPropertyUtil.
            getValuesFromPerpertyFile("resource/"+activeEnvironment+"it_wroks.properties",
                    "my.property.string");

    //Do what you want to
    logger.info(myEnvSpecificValue);

}