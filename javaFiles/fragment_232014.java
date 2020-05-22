import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

/**
 *
 * @author Tristan Everitt
 */
public class AlphaNumericStringComparatorTester
{
    @Test
    public void testHumanNaturalSort1()
    {
        List<String> randomList = Arrays.asList("z1.doc", "z10.doc", "z100.doc", "z101.doc", "z102.doc", "z11.doc", "z12.doc", "z13.doc", "z14.doc", "z15.doc", "z16.doc", "z17.doc", "z18.doc",
                "z19.doc", "z2.doc", "z20.doc", "z3.doc", "z4.doc", "z5.doc", "z6.doc", "z7.doc", "z8.doc", "z9.doc", "z1.2.doc", "z1.3.doc");
        Collections.shuffle(randomList, new Random());

        List<String> expected = Arrays.asList("z1.doc", "z1.2.doc", "z1.3.doc", "z2.doc", "z3.doc", "z4.doc", "z5.doc", "z6.doc", "z7.doc", "z8.doc", "z9.doc", "z10.doc", "z11.doc", "z12.doc",
                "z13.doc", "z14.doc", "z15.doc", "z16.doc", "z17.doc", "z18.doc", "z19.doc", "z20.doc", "z100.doc", "z101.doc", "z102.doc");

        assertNotEquals(expected, randomList);
        Collections.sort(randomList, new AlphaNumericStringComparator());
        assertEquals(expected, randomList);
    }

    @Test
    public void testHumanNaturalSort2()
    {
        List<String> randomList = Arrays.asList("z1.doc", "z10.doc", "z100.doc", "z101.doc", "z102.doc", "z11.doc", "z12.doc", "z13.doc", "z14.doc", "z15.doc", "z16.doc", "z17.doc", "z18.doc",
                "z19.doc", "z2.doc", "z20.doc", "z3.doc", "z4.doc", "z5.doc", "z6.doc", "z7.doc", "z8.doc", "z9.doc", "z1.2.doc", "z1.3.doc");
        Collections.shuffle(randomList, new Random());

        List<String> expected = Arrays.asList("z1.doc", "z1.2.doc", "z1.3.doc", "z2.doc", "z3.doc", "z4.doc", "z5.doc", "z6.doc", "z7.doc", "z8.doc", "z9.doc", "z10.doc", "z11.doc", "z12.doc",
                "z13.doc", "z14.doc", "z15.doc", "z16.doc", "z17.doc", "z18.doc", "z19.doc", "z20.doc", "z100.doc", "z101.doc", "z102.doc");

        assertNotEquals(expected, randomList);
        Collections.sort(randomList, new AlphaNumericStringComparator());
        assertEquals(expected, randomList);
    }

    @Test
    public void testHumanNaturalSort3()
    {
        List<String> randomList = Arrays.asList("yr1", "yr10", "yr11", "yr12", "yr13", "yr2", "yr 3", "yr 3.4", "yr 4", "yr5", "yr6", "yr7", "yr8", "yr 9");
        Collections.shuffle(randomList, new Random());

        List<String> expected = Arrays.asList("yr1", "yr2", "yr 3", "yr 3.4", "yr 4", "yr5", "yr6", "yr7", "yr8", "yr 9", "yr10", "yr11", "yr12", "yr13");

        assertNotEquals(expected, randomList);
        Collections.sort(randomList, new AlphaNumericStringComparator());
        assertEquals(expected, randomList);
    }

    @Test
    public void testHumanNaturalSort4()
    {
        List<String> randomList = Arrays.asList("1-2", "1-02", "1-20", "10-20", "fred", "jane", "pic01", "pic2", "pic02", "pic02a", "pic3", "pic4", "pic 4 else", "pic 5", "pic05", "pic 5",
                "pic 5 something", "pic 6", "pic   7", "pic100", "pic100a", "pic120", "pic121", "pic02000", "tom", "x2-g8", "x2-y7", "x2-y08", "x8-y8");
        Collections.shuffle(randomList, new Random());

        List<String> expected = Arrays.asList("1-2", "1-02", "1-20", "10-20", "fred", "jane", "pic01", "pic02", "pic2", "pic02a", "pic3", "pic4", "pic 4 else", "pic 5", "pic05", "pic 5",
                "pic 5 something", "pic 6", "pic   7", "pic100", "pic100a", "pic120", "pic121", "pic02000", "tom", "x2-g8", "x2-y7", "x2-y08", "x8-y8");

        assertNotEquals(expected, randomList);
        Collections.sort(randomList, new AlphaNumericStringComparator());
        assertEquals(expected, randomList);
    }

}