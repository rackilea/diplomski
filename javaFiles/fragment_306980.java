@RunWith(Parameterized.class)
public class MyTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 0, -1 }, { -1, 0 }
        });
    }

    @Parameterized.Parameter
    public int row;

    @Parameterized.Parameter(value = 1)
    public int col;

    @Test(expected = IndexOutOfBoundsException.class)
    public void validateIndices(){
        check(row, col);
    }
}