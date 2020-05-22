import java.util.List;

import com.google.gson.Gson;

public class GSonTest {

    public static void main(final String[] args) {
        Gson gson = new Gson();
        System.out.println(gson.fromJson("{        \"type\": \"Point\",        \"coordinates\": [          16.7594706041998,          43.148716514354945        ]      }", Geometry.class));
    }

    public static class Geometry {

        List<Float> coordinates;

        public List<Float> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(final List<Float> coordinates) {
            this.coordinates = coordinates;
        }

        @Override
        public String toString() {
            return "Geometry [coordinates=" + coordinates + "]";
        }

    }

}