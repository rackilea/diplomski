import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
...
@Test
public void add_with_index_less_than_zero_or_greater_than_size() {
    Assertions.assertThrows(IllegalArgumentException.class, 
                             () -> l0.add(42, 10));
    Assertions.assertThrows(IllegalArgumentException.class, 
                             () -> l0.add(42, -1));
}