public class ResponseData {

@SerializedName("code")
private Integer code;
@SerializedName("error_message")
private Object errorMessage;
@SerializedName("data")
private List<Datum> data = null;

public Integer getCode() {
    return code;
}

public void setCode(Integer code) {
    this.code = code;
}

public Object getErrorMessage() {
    return errorMessage;
}

public void setErrorMessage(Object errorMessage) {
    this.errorMessage = errorMessage;
}

public List<Datum> getData() {
    return data;
}

public void setData(List<Datum> data) {
    this.data = data;
}

}