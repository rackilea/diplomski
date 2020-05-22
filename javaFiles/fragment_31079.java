public final class SimpleForm
{
    final JPanel testPanel;
    final JButton testButton;

    public SimpleForm()
    {
        testPanel = new JPanel();
        testPanel.setName("testPanel");
        testButton = new JButton();
        testButton.setName("testButton");
        testPanel.add(testButton);
    }
}

public final class SimpleService {
    public String getValue() { return null; }
}

public final class SimpleController
{
   private final SimpleForm form;

   public SimpleController()
   {
      form = new SimpleForm();
      SimpleService service = new SimpleService();
      form.testButton.setText(service.getValue());
   }

   public JPanel getPanel() { return form.testPanel; }
}

public final class SimpleTest extends FestSwingJUnitTestCase
{
   FrameFixture window;
   @NonStrict SimpleService service;

   @Override
   protected void onSetUp()
   {
      FailOnThreadViolationRepaintManager.install();

      // Record expectations *before* they are replayed:
      new Expectations() {{ service.getValue(); result = "TEST"; }};

      JFrame frameUi = GuiActionRunner.execute(new GuiQuery<JFrame>() {
         @Override
         protected JFrame executeInEDT()
         {
            SimpleController controller = new SimpleController();

            JFrame frame = new JFrame("TEST");
            frame.add(controller.getPanel());
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.pack();
            return frame;
         }
      });

      robot().settings().delayBetweenEvents(1000);

      window = new FrameFixture(robot(), frameUi);
      window.show();
   }

   @Test
   public void test()
   {
      // This works provided "service.getValue()" gets called *after* 
      // expectations are recorded. With the call happening during the
      // creation of the window, it must be recorded at the beginning
      // of the "onSetUp" method.
      window.panel("testPanel").button("testButton").requireText("TEST");
   }
}