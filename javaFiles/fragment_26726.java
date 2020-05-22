package com.example;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

public class To {

@Expose
private List<String> names = new ArrayList<String>();
@Expose
private List<String> callerIds = new ArrayList<String>();
@Expose
private List<String> captions = new ArrayList<String>();

public List<String> getNames() {
return names;
}
public void setNames(List<String> names) {
this.names = names;
}
public List<String> getCallerIds() {
return callerIds;
}
public void setCallerIds(List<String> callerIds) {
this.callerIds = callerIds;
}
public List<String> getCaptions() {
return captions;
}
public void setCaptions(List<String> captions) {
this.captions = captions;
}

}