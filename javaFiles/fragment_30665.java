package com.example.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
  @Result(name="failure", location="fail.jsp")
})
public class HelloWorld extends ActionSupport {
  @Action(value="/different/url",
    results={@Result(name="success", location="http://struts.apache.org", type="redirect")}
  )
  public String execute() {
    return SUCCESS;
  }

  @Action("/another/url")

  public String doSomething() {
    return SUCCESS;
  }
}