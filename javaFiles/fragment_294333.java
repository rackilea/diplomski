class BaseResponse {
    private String requestUuid;

    public getRequestUuid() {
        return requestUuid;
    }
}

class OtherResponse extends BaseResponse {
    @Override
    @JsonProperty("request_uuid")
    public getRequestUuid() {
        return super.getRequestUuid();
    }
}