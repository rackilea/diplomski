-----------------------------------com.example.AssignedTo.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AssignedTo {

@SerializedName("link")
@Expose
private String link;
@SerializedName("value")
@Expose
private String value;

public String getLink() {
return link;
}

public void setLink(String link) {
this.link = link;
}

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
}

}
-----------------------------------com.example.CmdbCi.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CmdbCi {

@SerializedName("link")
@Expose
private String link;
@SerializedName("value")
@Expose
private String value;

public String getLink() {
return link;
}

public void setLink(String link) {
this.link = link;
}

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
}

}
-----------------------------------com.example.Example.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

@SerializedName("result")
@Expose
private Result result;

public Result getResult() {
return result;
}

public void setResult(Result result) {
this.result = result;
}

}
-----------------------------------com.example.Location.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

@SerializedName("link")
@Expose
private String link;
@SerializedName("value")
@Expose
private String value;

public String getLink() {
return link;
}

public void setLink(String link) {
this.link = link;
}

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
}

}
-----------------------------------com.example.OpenedBy.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpenedBy {

@SerializedName("link")
@Expose
private String link;
@SerializedName("value")
@Expose
private String value;

public String getLink() {
return link;
}

public void setLink(String link) {
this.link = link;
}

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
}

}
-----------------------------------com.example.Result.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

@SerializedName("upon_approval")
@Expose
private String uponApproval;
@SerializedName("location")
@Expose
private Location location;
@SerializedName("expected_start")
@Expose
private String expectedStart;
@SerializedName("reopen_count")
@Expose
private String reopenCount;
@SerializedName("sys_domain")
@Expose
private SysDomain sysDomain;
@SerializedName("description")
@Expose
private String description;
@SerializedName("activity_due")
@Expose
private String activityDue;
@SerializedName("sys_created_by")
@Expose
private String sysCreatedBy;
@SerializedName("resolved_at")
@Expose
private String resolvedAt;
@SerializedName("assigned_to")
@Expose
private AssignedTo assignedTo;
@SerializedName("business_stc")
@Expose
private String businessStc;
@SerializedName("wf_activity")
@Expose
private String wfActivity;
@SerializedName("sys_domain_path")
@Expose
private String sysDomainPath;
@SerializedName("cmdb_ci")
@Expose
private CmdbCi cmdbCi;
@SerializedName("opened_by")
@Expose
private OpenedBy openedBy;
@SerializedName("subcategory")
@Expose
private String subcategory;
@SerializedName("comments")
@Expose
private String comments;

public String getUponApproval() {
return uponApproval;
}

public void setUponApproval(String uponApproval) {
this.uponApproval = uponApproval;
}

public Location getLocation() {
return location;
}

public void setLocation(Location location) {
this.location = location;
}

public String getExpectedStart() {
return expectedStart;
}

public void setExpectedStart(String expectedStart) {
this.expectedStart = expectedStart;
}

public String getReopenCount() {
return reopenCount;
}

public void setReopenCount(String reopenCount) {
this.reopenCount = reopenCount;
}

public SysDomain getSysDomain() {
return sysDomain;
}

public void setSysDomain(SysDomain sysDomain) {
this.sysDomain = sysDomain;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getActivityDue() {
return activityDue;
}

public void setActivityDue(String activityDue) {
this.activityDue = activityDue;
}

public String getSysCreatedBy() {
return sysCreatedBy;
}

public void setSysCreatedBy(String sysCreatedBy) {
this.sysCreatedBy = sysCreatedBy;
}

public String getResolvedAt() {
return resolvedAt;
}

public void setResolvedAt(String resolvedAt) {
this.resolvedAt = resolvedAt;
}

public AssignedTo getAssignedTo() {
return assignedTo;
}

public void setAssignedTo(AssignedTo assignedTo) {
this.assignedTo = assignedTo;
}

public String getBusinessStc() {
return businessStc;
}

public void setBusinessStc(String businessStc) {
this.businessStc = businessStc;
}

public String getWfActivity() {
return wfActivity;
}

public void setWfActivity(String wfActivity) {
this.wfActivity = wfActivity;
}

public String getSysDomainPath() {
return sysDomainPath;
}

public void setSysDomainPath(String sysDomainPath) {
this.sysDomainPath = sysDomainPath;
}

public CmdbCi getCmdbCi() {
return cmdbCi;
}

public void setCmdbCi(CmdbCi cmdbCi) {
this.cmdbCi = cmdbCi;
}

public OpenedBy getOpenedBy() {
return openedBy;
}

public void setOpenedBy(OpenedBy openedBy) {
this.openedBy = openedBy;
}

public String getSubcategory() {
return subcategory;
}

public void setSubcategory(String subcategory) {
this.subcategory = subcategory;
}

public String getComments() {
return comments;
}

public void setComments(String comments) {
this.comments = comments;
}

}
-----------------------------------com.example.SysDomain.java-----------------------------------

package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SysDomain {

@SerializedName("link")
@Expose
private String link;
@SerializedName("value")
@Expose
private String value;

public String getLink() {
return link;
}

public void setLink(String link) {
this.link = link;
}

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
}

}