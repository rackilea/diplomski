@RunWith(SpringJUnit4ClassRunner.class)
public class AutowiringTest {
  @Autowired Usage test;

  public void testAutowiring() {
    assertThat(test.foo.getGenericType(), equalTo(Artifact.class));
    assertThat(test.bar.getGenericType(), equalTo(Material.class));
  }
}