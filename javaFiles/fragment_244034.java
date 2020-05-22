public class ReturnData {
    public ReturnData() {
        OperationResult = Result.Failed;
        Messages = "An Error Occured";
        UpdateAvailable = "0";
        ResultData = "";
    }

    public int OperationResult;
    public String Messages;
    public String UpdateAvailable;
    public MyResultData ResultData;
}

class MyResultData {
    public String SessionId;
    public String UserName;
    public String AccountId;
    public List<String> Roles;
    public String DisplayName;
    public int Status;
    public int Type;
}

ReturnData rd = new Gson().fromJson(jsonString, ReturnData.class);