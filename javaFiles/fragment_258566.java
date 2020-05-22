package com.demo;

//all import statement

public class ActivitiForm implements ExecutionListener {

  public void notify(ExecutionListenerExecution execution) throws Exception {
    String name = (String) execution.getVariable("name");
    String comment = (String) execution.getVariable("comment");
    System.out.println(name + " made the following comment: " + comment);           //see this sys.out in your admin log.
  }
}