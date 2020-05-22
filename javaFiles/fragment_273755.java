import io.cucumber.java.en.Given;

import java.time.Instant;
import java.time.LocalDate;

public class DateSteps {

    @Given("an object with dates")
    public void and_object_with_dates(Dates dates) {

    }

    public static class Dates {
        public LocalDate localDate;
        public Instant instant;

    }
}