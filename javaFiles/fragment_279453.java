public class Input {
    public String inputValue;
}

public class Output {
    public String outputValue;
}

@Api(name = "myApi", version = "v1")
public class MyApi {

    @ApiMethod(name = "hello")
    public Output hello(Input input) {
        Output response = new Output();
        response.resultValue = "Hello " + input.inputValue;
        return response;
    }

}