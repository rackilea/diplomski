public class Example {
    private String Status;
    private Result Result;
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public Result getResult() {
        return Result;
    }
    public void setResult(Result result) {
        Result = result;
    }
    @Override
    public String toString() {
        return "Example [Status=" + Status + ", Result=" + Result + "]";
    }

}