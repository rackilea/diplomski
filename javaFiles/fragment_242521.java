package de.scrum_master.app;

import java.io.IOException;
import java.util.Map;

public class FirstRunnableProcess extends RunnableProcess {
  @Override
  public void run(Map processContext) throws IOException {
    System.out.println("I am #1");
    result = "first";
  }
}