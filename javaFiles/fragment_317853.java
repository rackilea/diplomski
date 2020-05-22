@RunWith(MockitoJUnitRunner.class)
public class TestSampleTest {

  @InjectMocks
  ChangerImpl changer;

  @Test(expected = NullPointerException.class)
  public void test1(){

    GroupProvider currentGroupAdm = mock(GroupProvider.class);
    doReturn(null).when(currentGroupAdm).getDocs();

    GroupProvider groupAdm = mock(GroupProvider.class);
    oReturn("sample2").when(groupAdm).getDocs();

    changer.hasDocsChangedRequired(currentGroupAdm, groupAdm);
  }

  @Test
  public void test2(){

    GroupProvider currentGroupAdm = mock(GroupProvider.class);
    doReturn("sample1").when(currentGroupAdm).getDocs();

    GroupProvider groupAdm = mock(GroupProvider.class);
    doReturn("sample2").when(groupAdm).getDocs();

    Assert.assertThat(changer.hasDocsChangedRequired(currentGroupAdm, groupAdm), is(true));
  }

  @Test
  public void test3(){

    GroupProvider currentGroupAdm = mock(GroupProvider.class);
    doReturn("sample1").when(currentGroupAdm).getDocs();

    GroupProvider groupAdm = mock(GroupProvider.class);
    doReturn("sample1").when(groupAdm).getDocs();

    Assert.assertThat(changer.hasDocsChangedRequired(currentGroupAdm, groupAdm), is(false));
  }

}