package test;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main( String[] args ) throws Exception {
        ObjectMapper om = new ObjectMapper();
        // configuring as specified         
        om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        // scalar example
        String json = "{\"foo\":2}";
        // array example
        String otherJson = "{\"foo\":[3,4,5]}";
        // de-serializing scalar and printing value
        Main m = om.readValue(json, Main.class);
        System.out.println(Arrays.toString(m.foo));
        // de-serializing array and printing value
        Main otherM = om.readValue(otherJson, Main.class);
        System.out.println(Arrays.toString(otherM.foo));
    }
    @JsonProperty(value="foo")
    protected double[] foo;
}