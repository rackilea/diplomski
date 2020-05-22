public ControllerTest {
   @Test
   public shouldDoTestOfShowView() {
      Controller controller = new Controller();
      Repository repository = new Repository();

      ReflectionTestUtils.setField(controller, "repo", repository); 
   }
}