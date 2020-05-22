public class StepSy {
    static File runDirectory;
    private static boolean fileInitFlag = false;
    DataObject data;


    @Before
    public void before() {
        if(!fileInitFlag) {
             runDirectory = new File(FileIdGenerator.getRunId());
             fileInitFlag= true;
        }
    }



    @After
    public void after(Scenario scenario) {
        data.writeTo(runDirectory, scenario.getName());
    }
}