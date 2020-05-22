import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JsonbDateConfig implements ContextResolver<Jsonb> {  
    private final Jsonb jsonB;  


    public JsonbDateConfig()  
    {  
        JsonbConfig config = new JsonbConfig();  
        config.setProperty(JsonbConfig.DATE_FORMAT, JsonbDateFormat.TIME_IN_MILLIS);  
        jsonB = JsonbBuilder.create(config);  
    }  


    @Override  
    public Jsonb getContext(Class objectType) {  
        return jsonB;  
    }  
}