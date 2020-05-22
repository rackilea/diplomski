import org.junit.Assert;
import org.junit.Test;

public class CellsTest {

    @Test
    void testHasWallOnRight() {
        //setup
        int[][] target = new int[][] { { 0, 0, 0, 0 }, 
                { 0, 0, 0, 0 }, 
                { 0, 0, 0, 0 }, 
                { 0, 0, 0, 0 } };

        Cells a = new Cells(target);

        //act
        boolean result = a.hasWallOnRight(1,1);

        //assert
        Assert.assertFalse(result);
    }
}