@ContextConfiguration(classes={PersistenceConfig.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class MainTest {
}

public BookManagerTest extends MainTest {
...
}