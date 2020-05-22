package de.scrum_master.app;

public class ErrorResponse implements Response {
  private String message;
  private Exception exeception;

  public ErrorResponse(String message, Exception exeception) {
    this.message = message;
    this.exeception = exeception;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public Exception getExeception() {
    return exeception;
  }

  @Override
  public String toString() {
    return "ErrorResponse [message=" + message + ", exeception=" + exeception + "]";
  }
}