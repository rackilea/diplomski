@Tested CUT cut;
@Injectable DummyDAO dao;
@Injectable List<VO> res;

@Test
public void testSomething() throws Exception {
    new Expectations() {{
        dao.getSearchCriteria(anyString, anyInt); result = res; 
    }};
    List<VO> output = cut.methodBeingTested();
    // assertions go here, like that output and res are the same
    // you can also put Verifications here
}