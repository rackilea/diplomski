package com.example.main;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.example.dto.Computer;

public class JSONParse {

    public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException {

        /* JSON provider */
        URL url = new URL("http://api.engin.umich.edu/hostinfo/v1/computers.json?building=PIERPONT&room=B505");

        ObjectMapper mapper = new ObjectMapper();

        /*
         * This allows the ObjectMapper to accept single values for a collection.
         * For example: "location" property in the returned JSON is a collection that 
         * can accept multiple objects but, in deserialization process, this property just 
         * have one object and causes an Exception.
         */
        mapper.configure(Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        /* 
         * If some JSON property is not present, avoid exceptions setting
         * FAIL_ON_UNKNOWN_PROPERTIES to false 
         */
        mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        /* Get all computers */
        List<Computer> computers = mapper.readValue(url, new TypeReference<List<Computer>>(){});

        /* Print each computer (previously overriding "toString()" method) */
        for(Computer computer : computers) {
            System.out.println(computer.toString());
        }

    }

}