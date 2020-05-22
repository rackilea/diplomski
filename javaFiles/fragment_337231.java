@Tested CUT cut;
@Injectable DummyDAO dao;
@Mocked VO vo;

@Test
public void testSomething() throws Exception {
    final List<VO> res = new ArrayList<VO>();
    Collections.addAll(res, vo, vo, vo, vo);
    new Expectations() {{
        dao.getSearchCriteria(anyString, anyInt); result = res;
    }};

    new Expectations(4) {{
        vo.getFoo(); returns(5, 47, 13, -7);
    }};

    cut.methodBeingTested();
    // assertions go here, like that you handled the negative number properly
    // you can also put Verifications here
}