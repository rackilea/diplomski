package de.scrum_master.app;

public class NormalResponse implements Response {
  private String message = "OK";

  @Override
  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return "NormalResponse [message=" + message + "]";
  }
}