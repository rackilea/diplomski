public class ListenerTest{

   @InjectMocks
   private Listener repeatRejectAnalysis_Listener = new Listener();

   @Mock
   private RepeatRejectAnalysis rs;

   @Before
   public void init(){
      MockitoAnnotation.initMocks(this);
   }

   // reuse the exact same method as you have now.
   @Test
   public void testIsApplyChecked() {
    JCheckBox Rra_Apply_Field=Mockito.mock(JCheckBox.class);
    Mockito.when(Rra_Apply_Field.isSelected()).thenReturn(true);
    RepeatRejectAnalysis rs =Mockito.mock(RepeatRejectAnalysis.class);
    Mockito.when(rs.getApplytoAllState()).thenReturn(true);
    boolean val=repeatRejectAnalysis_Listener.isApplyChecked();
    Assert.assertEquals(true, val);
  }

}