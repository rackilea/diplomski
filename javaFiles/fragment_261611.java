import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
public class MyPropertyUtil {
    public static String getValuesFromPerpertyFile(String filename,String key){
        String value = null;
        Configuration config = getConfiguration(filename);
        value = config.getString(key);

        return value;

    }

    public static Configuration getConfiguration(String file){

        Configuration config = null;

        try{
            Parameters params = new Parameters();
            FileBasedConfigurationBuilder<FileBasedConfiguration> 
                builder =new FileBasedConfigurationBuilder
                <FileBasedConfiguration>(PropertiesConfiguration.class)
                .configure(params.properties().setFileName(file));

            config = builder.getConfiguration();

        }catch(Exception ex){
            ex.printStackTrace();
        }finally{

        }

        return config;
    }

}