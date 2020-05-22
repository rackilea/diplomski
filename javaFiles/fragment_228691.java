import java.util.Random;

import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.Filter;

public class RandomAcceptFilter extends Filter {
    private Random rand = new Random();

    @Override
    public boolean accept(Key k, Value v) {
        return rand.nextDouble() < .05;
    }
}