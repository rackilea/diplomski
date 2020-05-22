import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.foodit.data.remote.wrapper.SignupDetailsWrapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "code",
        "msg",
        "details"
})
public class LoginResponse {

    @JsonProperty("code")
    private int code;
    @JsonProperty("msg")
    private String msg;
    @JsonProperty("details")
    private List<LoginDetailsWrapper> details = new ArrayList<LoginDetailsWrapper>();

    @JsonProperty("code")
    public int getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(int code) {
        this.code = code;
    }

    @JsonProperty("msg")
    public String getMsg() {
        return msg;
    }

    @JsonProperty("msg")
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @JsonProperty("details")
    public List<LoginDetailsWrapper> getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(List<LoginDetailsWrapper> details) {
        this.details = details;
    }

}