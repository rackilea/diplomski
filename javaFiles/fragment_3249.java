import java.util.List;
import java.util.LinkedList;

public class TypeTest {
    private static final int STORAGE_SIZE = 10;

    private static final List<List<Integer>> storage = new LinkedList<>();

    static {
        for ( int elementNo = 0; elementNo < STORAGE_SIZE; elementNo++ ) {
            storage.add( new LinkedList<>() );
        }
    }
}