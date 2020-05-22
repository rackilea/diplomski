// new constructor
public DataResponse(DataErrorEnum error, DataStatusEnum status) {
    this(null, error, status);
}

public DataResponse(String response, DataErrorEnum error, DataStatusEnum status) {
    this.response = response;
    this.error = error;
    this.status = status;
}