@RunWith(Parameterized.class)
public class ParameterizedTest {
    @Parameters(name = "{index}: file {0}")
    public static Iterable<Object[]> data() {
        File[] files = new File("/temp").listFiles();

        List<Object[]> objects = new ArrayList<Object[]>(files.length);

        for (File file : files) {
            objects.add(new Object[] { file.getAbsolutePath() });
        }

        return objects;
    }

    private final String filename;

    public ParameterizedTest(String filename) {
        this.filename = filename;
    }

    @Test
    public void test() {
        System.out.println("test filename=" + filename);
    }
}