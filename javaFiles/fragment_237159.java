import java.io.IOException;
import java.util.List;
import cars.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParserMain {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        VehiclesHolder holder=objectMapper.readValue(ParserMain.class.getResourceAsStream("input.json"), VehiclesHolder.class);
        List<Vehicle> vehicles=holder.getVehicles();
    }
}