package android.app;

import android.content.Context;

public class AlertDialog {
  public AlertDialog() {}

  public static class Builder {
    private String title;
    private String message;

    public Builder(Context target) {}

    public Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    public void show() {
      System.out.println("ALERT DIALOG: " + title + " -> " + message);
    }
  }
}