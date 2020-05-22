import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.util.Locale.ENGLISH;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>(
                "integerList",  //this name can be used in the step method
                "(-?[0-9]+(,\\s*-?[0-9]+)*)", //regexp to match to a comma separated integer list which can contain negative numbers and whitespaces as well
                List.class,  //the expected parameter type
                this::transform  // equivalent to (String s) -> this.transformer(s), this is the transformer method which will be used to create the desired step parameter 
        ));
    }

//transforms the string form to an integer list
    private List<Integer> transform(String integers) {
        List<String> integersAsString = Arrays.asList(integers.split(","));
        return integersAsString.stream().map(s -> Integer.valueOf(s.trim())).collect(Collectors.toList());
    }
}