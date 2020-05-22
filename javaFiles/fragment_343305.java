package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Test {

    static String json = "{\"library\": [{\"key\":\"val\"},{\"key\":\"val\"}]}";

    static class JsonClass {
        private ArrayList<Map<?,?>> library;

        public ArrayList<Map<?, ?>> getLibrary() {
            return library;
        }

        public void setLibrary(ArrayList<Map<?, ?>> library) {
            this.library = library;
        }
    }

    public static void main(String[] args) 
            throws JsonParseException, JsonMappingException, IOException {

        JsonClass parsed = new ObjectMapper().readValue(json, Test.JsonClass.class);
        System.out.println(parsed.getLibrary());

    }

}