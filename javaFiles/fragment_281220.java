public class MyServletDispatcherResult extends ServletDispatcherResult {

    private String resultPath;

    public String getResultPath() {
        return resultPath;
    }

    @Inject(value = "struts.result.path", required = false)
    public void setResultPath(String resultPath) {
        this.resultPath = resultPath;
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(resultPath+location);
    }

    public MyServletDispatcherResult() {
        super();
    }

//    @Inject
//    public MyServletDispatcherResult(String location) {
//
//        super(resultPath+location);
//    }
}