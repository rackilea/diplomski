import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.CaptureGroupTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<>(
                "random",
                "random\\(([0-9]+),(true|false),(true|false)\\)",
                String.class,
                new CaptureGroupTransformer<>() {
                    @Override
                    public String transform(String[] args) {
                        return RandomStringUtils.random(Integer.parseInt(args[0]), Boolean.valueOf(args[1]), Boolean.valueOf(args[2]));
                    }
                })
        );
    }
}