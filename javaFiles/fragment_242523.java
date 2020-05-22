package de.scrum_master.app;

import java.io.IOException;

public class Application {
  public static void main(String[] args) throws IOException {
    new FirstRunnableProcess().run(null);
    new SecondRunnableProcess().run(null);
  }
}