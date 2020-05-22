package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

@SerializedName("role")
@Expose
private String role;
@SerializedName("operationId")
@Expose
private String operationId;
@SerializedName("parameters")
@Expose
private Parameters parameters;

public String getRole() {
return role;
}

public void setRole(String role) {
this.role = role;
}

public String getOperationId() {
return operationId;
}

public void setOperationId(String operationId) {
this.operationId = operationId;
}

public Parameters getParameters() {
return parameters;
}

public void setParameters(Parameters parameters) {
this.parameters = parameters;
}

}