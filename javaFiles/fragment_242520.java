package de.scrum_master.app;

import java.io.IOException;
import java.util.Map;

public abstract class RunnableProcess {
  protected String result = "foo";

  public abstract void run(Map processContext) throws IOException;
}