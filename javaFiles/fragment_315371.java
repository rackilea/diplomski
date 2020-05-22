import  org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
...
@Test
public void add_with_null_arg() {
    Assertions.assertThrows(IllegalArgumentException.class, 
                             () -> l0.add(null, 10));
}