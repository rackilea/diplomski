public class Response<T> {

  private static final String R_MSG_EMPTY = "";
  private static final String R_CODE_OK = "OK";

  private final String responseCode;
  private final Date execDt;
  private final String message;

  private T response;

  /**
   * A Creates a new instance of Response
   *
   * @param code
   * @param message
   * @param execDt
   */
  public Response(final String code, final String message, final Date execDt) {

    this.execDt = execDt == null ? Calendar.getInstance().getTime() : execDt;
    this.message = message == null ? Response.R_MSG_EMPTY : message;
    this.responseCode = code == null ? Response.R_CODE_OK : code;
    this.response = null;
  }

  /**
   * @return the execDt
   */
  public Date getExecDt() {

    return this.execDt;
  }

  /**
   * @return the message
   */
  public String getMessage() {

    return this.message;
  }

  /**
   * @return the response
   */
  public T getResponse() {

    return this.response;
  }

  /**
   * @return the responseCode
   */
  public String getResponseCode() {

    return this.responseCode;
  }

  /**
   * sets the response object
   *
   * @param obj
   * @return
   */
  public Response<T> setResponse(final T obj) {

    this.response = obj;
    return this;
  }
}