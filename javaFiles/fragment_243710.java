@RunWith(Parameterized.class)
public class EntityTest {

    @Parameters(name = "entity #{index} \"{0}\" must be properly annotated")
    public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { Note.class },
        { Something.class }
    });
    }

    private final Class<?> entityClass;

    public EntityTest(final Class<?> entityClass) {
    this.entityClass = entityClass;
    }

    @Test
    public void someTest() {
       // test your entityClasss
    }

}