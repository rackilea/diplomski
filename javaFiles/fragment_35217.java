package injectcontext;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class DemoController {

    FirstService firstService;

    SecondService secondService;

    public DemoController(FirstService firstService, SecondService secondService) {
        this.firstService = firstService;
        this.secondService = secondService;
    }

    @Get("/first")
    public String first() {
        boolean isNull = firstService.isContextNull();

        return "firstService.isContextNull() == " + isNull;
    }

    @Get("/second")
    public String second() {
        boolean isNull = secondService.isContextNull();

        return "secondService.isContextNull() == " + isNull;
    }
}