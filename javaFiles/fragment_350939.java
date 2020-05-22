package com.lm.infrastructure;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
@Produces( MediaType.APPLICATION_JSON )
public class JacksonProducer implements ContextResolver<ObjectMapper> {

    public JacksonProducer() throws Exception {
        this.json
            = new ObjectMapper()
            .findAndRegisterModules()
            .configure( WRITE_DATES_AS_TIMESTAMPS, false )
            .configure( FAIL_ON_UNKNOWN_PROPERTIES, false );
    }

    @Override
    public ObjectMapper getContext( Class<?> objectType ) {
        return json;
    }

    private final ObjectMapper json;
}