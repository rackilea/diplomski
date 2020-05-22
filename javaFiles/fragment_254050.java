@Test
public void testPageRender() {
    WicketTester tester = new WicketTester();
    tester.startPage( MyPage.class );
    tester.assertNoErrors();
}