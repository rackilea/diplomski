package bench;

import com.google.common.collect.ImmutableMap;
import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class Requirements {
    private static boolean enabled = true;

    private String name = "name";
    private String value = "value";

    @Benchmark
    public Object assertMethod() {
        if (enabled)
            return requireThat(value, name);
        return null;
    }

    @Benchmark
    public Object requireMethod() {
        return requireThat(value, name);
    }

    public static Object requireThat(String parameter, String name) {
        if (name.trim().isEmpty())
            throw new IllegalArgumentException();
        return new StringRequirementsImpl(parameter, name, new Configuration());
    }

    static class Configuration {
        private Object context = ImmutableMap.of();
    }

    static class StringRequirementsImpl {
        private String parameter;
        private String name;
        private Configuration config;
        private ObjectRequirementsImpl asObject;

        StringRequirementsImpl(String parameter, String name, Configuration config) {
            this.parameter = parameter;
            this.name = name;
            this.config = config;
            this.asObject = new ObjectRequirementsImpl(parameter, name, config);
        }
    }

    static class ObjectRequirementsImpl {
        private Object parameter;
        private String name;
        private Configuration config;

        ObjectRequirementsImpl(Object parameter, String name, Configuration config) {
            this.parameter = parameter;
            this.name = name;
            this.config = config;
        }
    }
}