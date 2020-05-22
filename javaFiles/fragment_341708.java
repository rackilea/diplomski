public abstract class AbstractClusterMRTest {
    private static final Log LOG = LogFactory.getLog(AbstractClusterMRTest.class);

    public static final String DEFAULT_LOG_CATALOG = "local-mr-logs";
    public static final String SLASH = "/";
    public static final String MR_DATA_OUTPUT = "mr-data-output";
    public static final String DEFAULT_OUTPUT_FILE_NAME =  "part-r-00000";

    private static final int DEFAULT_REDUCE_NUM_TASKS = 1;


    private Configuration configuration;
    private FileSystem localFileSystem;
    private MiniMRCluster mrCluster;
    private JobConf mrClusterConf;


    /**
     * Always provide path to log catalog.
     * */
    protected String getPathToLogCatalog(){
        File logCatalog = new File(getPathToOutputDirectory()+ SLASH + DEFAULT_LOG_CATALOG);
        if(!logCatalog.exists()){
            logCatalog.mkdir();
        }
        LOG.info("Path to log catalog is: "+logCatalog.getAbsolutePath());
        return logCatalog.getAbsolutePath();
    }

    private String getPathToOutputDirectory(){
        return System.getProperty("project.build.directory");
    }

    public void setup() throws IOException{
        System.setProperty("hadoop.log.dir", getPathToLogCatalog());

        configuration = new Configuration(true);
        localFileSystem = FileSystem.get(configuration);
        mrCluster = new MiniMRCluster(1, localFileSystem.getUri().toString(), 1, null, null, new JobConf(configuration));
        mrClusterConf = mrCluster.createJobConf();
    }

    public void tearDown() {
        if (mrCluster != null) {
            mrCluster.shutdown();
            mrCluster = null;
        }
    }

    /**
     * Use this method to get JobBuilder configured for testing purposes.
     * @return JobBuilder instance ready for further configuration.
     * */
    public JobBuilder createTestableJobInstance() throws IOException{
        return new JobBuilder(mrClusterConf, this.getClass().getSimpleName()+"-mrjob")
                .withNumReduceTasks(DEFAULT_REDUCE_NUM_TASKS);
    }

    /**
     * Pass configured JobBuilder and wait for completion
     * @param jobBuilder is a JobBuilder ready to submit
     * @return job completion result.
     * */
    public boolean buildSubmitAndWaitForCompletion(JobBuilder jobBuilder)
                        throws InterruptedException, IOException, ClassNotFoundException {
        String pathToInputFile = getPathToInputData();
        checkThatFileExists(pathToInputFile);

        Job job = jobBuilder.build();
        FileInputFormat.setInputPaths(job, pathToInputFile);
        FileOutputFormat.setOutputPath(job, createPath(getOutputPath()));

        LOG.info("Submitting job...");
        job.submit();
        LOG.info("Job has been submitted.");

        String trackingUrl = job.getTrackingURL();
        String jobId = job.getJobID().toString();
        LOG.info("trackingUrl:" +trackingUrl);
        LOG.info("jobId:" +jobId);

        return job.waitForCompletion(true);
    }

    /**
     * By declaration input data should be stored in test/resources folder:
     * ConcreteTestClassName/in/getInputDatasetName()
     * Don't forget to override @link{AbstractClusterMRTest#getInputDatasetName()}
     * @return path to input data
     * */
    protected String getPathToInputData(){
        String pathFile = this.getClass().getSimpleName() + SLASH + "in" + SLASH+ getInputDatasetName();
        LOG.info("Path for getting URL to file:" + pathFile);
        URL urlToFile = this.getClass().getClassLoader().getResource(pathFile);

        File file = FileUtils.toFile(urlToFile);
        return file.getAbsolutePath();
    }

    /**
     * Dataset should be placed in resources/ConcreteClusterMapReduceTest
     * @return a name of a file from catalog.
     * */
    protected abstract String getInputDatasetName();

    /**
     * @return path reducer output
     * default is: @{link AbstractClusterMapReduceTestOld#DEFAULT_OUTPUT_CATALOG}
     * */
    protected String getOutputPath(){
        return getPathToOutputDirectory()+ SLASH + MR_DATA_OUTPUT;
    }

    /**
     * @return text lines from reducer output file.
     * */
    protected List<String> getLinesFromOutputFile() throws IOException{
        String pathToResult = getOutputPath()+SLASH+DEFAULT_OUTPUT_FILE_NAME;
        File resultFile = new File(pathToResult);
        return FileUtils.readLines(resultFile);
    }

    public abstract String getEtalonOutputFileName();

    protected List<String> getLinesFromEtalonOutputFile() throws IOException{
        String pathFile = this.getClass().getSimpleName() + SLASH + "out" + SLASH+ getEtalonOutputFileName();
        LOG.debug("path to etalon file: "+ pathFile);
        URL urlToFile = this.getClass().getClassLoader().getResource(pathFile);

        File file = FileUtils.toFile(urlToFile);
        return FileUtils.readLines(file);

    }


    /**
     * Creates @{link Path} using absolute path to some FS resource
     * @return new Path instance.
     * */
    protected Path createPath(String pathToFSResource){
        return new Path(pathToFSResource);
    }

    public void checkThatFileExists(String absolutePathToFile){
        if(! new File(absolutePathToFile).exists()){
            throw new Error("Path to input file is incorrect. Can't run MR job. Incorrect path is:"+absolutePathToFile);
        }
    }

}