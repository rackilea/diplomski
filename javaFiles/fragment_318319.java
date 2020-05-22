@SpringBootApplication
public class So44423504Application {

    public static void main(String[] args) {
        SpringApplication.run(So44423504Application.class, args);
    }

    @RestController
    @RequestMapping(value = "/first")
    public static class MyFirstController {

        public static class MyStringRequestDTO extends RequestDTO<MyStringObject> {}

        public static class MyIntegerRequestDTO extends RequestDTO<MyIntegerObject> {}

        @PostMapping(value = "/something")
        public String doSomething(@ModelAttribute MyStringRequestDTO/*MyIntegerRequestDTO*/ requestDTO) throws JsonProcessingException {
            return new ObjectMapper().writeValueAsString(requestDTO);
        }
    }

    public static class RequestDTO<T> {
        private T someObject;
        // getter and setter
    }

    public static class MyStringObject {
        private String someString;

        public MyStringObject() { } // required since another non-default ctor is present.

        public MyStringObject(String someString){
            this.someString = someString;
        }

        // getter and setter
    }

    public static class MyIntegerObject {
        private Integer someInteger;
        private Integer anotherInteger;

        public MyIntegerObject() { } // required since another non-default ctor is present.

        public MyIntegerObject(Integer someInteger, Integer anotherInteger){
            this.someInteger = someInteger;
            this.anotherInteger = anotherInteger;
        }
        // getters and setters
    }
}