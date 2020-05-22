import groovy.xml.MarkupBuilder
import org.apache.commons.configuration.*

String configurationDefinition = "tomcat.configuration.xml"
File configurationDefinitionFile = new File(configurationDefinition)
FileWriter configurationDefinitionWriter = new FileWriter(configurationDefinitionFile)
MarkupBuilder fileList = new MarkupBuilder(configurationDefinitionWriter)
fileList.configuration() {
    properties(fileName:'tomcat.properties')
    xml(fileName:'server.xml')
}
configurationDefinitionWriter.close()

DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder();
builder.setFile(configurationDefinitionFile);
Configuration propertiesConfig = builder.getConfiguration(true);

XMLConfiguration conf = (XMLConfiguration)propertiesConfig.getConfiguration(1)
XMLConfiguration  interpolatedConf = (XMLConfiguration )conf.interpolatedConfiguration()
interpolatedConf.save("server_parsed.xml")