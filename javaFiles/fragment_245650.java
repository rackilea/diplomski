import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.junit.Test;

public class SomeTest {
    public static class Employee {
        private String bonus;

        public String getBonus() {
            return bonus;
        }

        public void setBonus(String bonus) {
            this.bonus = bonus;
        }
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public static class Partner extends Employee {
        @Override
        public String getBonus() {
            return super.getBonus();
        }
    }

    @Test
    public void testSerialize() throws Exception {
        Employee employee = new Employee();
        Partner partner = new Partner();

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("Employee: " + objectMapper.writeValueAsString(employee));
        System.out.println(" Partner: " + objectMapper.writeValueAsString(partner));
    }
}