import com.google.common.collect.Iterables;
import java.util.Arrays;

public class CellTypeB extends Cell
{
    public boolean State = false;

    @Override
    public void update(Cell[] neighbors) {
        Iterable<CellTypeA> onlyAs = Iterables.filter(Arrays.asList(neighbors), CellTypeA.class);
        for(CellTypeA a: onlyAs) {
            State = (a.getData() > 10);
        }   
    }   
}