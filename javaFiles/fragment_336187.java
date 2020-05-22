import java.lang.reflect.Field
import java.lang.reflect.Modifier

...

    def setup() {

        Field field = BackendCredentials.getDeclaredField("logger")
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, Mock(Logger))
    }