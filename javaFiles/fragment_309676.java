private UsersLoader loader;

@Before
public void setUp() {
  loader = spy(new UsersLoader());
}