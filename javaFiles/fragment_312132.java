@Test
public void testIssueTypeWithIssueTypeId(
    @Mocked FacesContext faces, @Mocked final ExternalContext extCtx
) {
    new Expectations() {{ extCtx.getRemoteUser(); result = "test"; }};

    DisplayIssuesBean bean = new DisplayIssuesBean();
    assertEquals("Bug", bean.setIssueTypeWithIssueTypeId(1));
}