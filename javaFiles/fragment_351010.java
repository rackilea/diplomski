public class ReportWriterClass{

   @Spy
   @InjectMocks
   private ReportWriter reportWriterSpy;

   @Mock
   private FileWrter fwMock;

   @Before
   public void init(){
       MockitoAnnotations.initMocks(this);
   }

   @Test
   public void shouldSendEmail_whenDiskIsFull() throws Exception{
       // Arrange
       Data data = new Data();

       doNothing().when(reportWriterSpy).sendEmailToSupport());
       doThrow(new DiskFullException()).when(fwMock).write(data);

       // Act
       reportWriterSpy.writeData(data);

      // Assert
      verify(reportWriterSpy).sendEmailToSupport();
   }
}