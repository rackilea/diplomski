package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

@SerializedName("Message")
@Expose
private List<Message> message = null;

public List<Message> getMessage() {
return message;
}

public void setMessage(List<Message> message) {
this.message = message;
}

}


package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

@SerializedName("Emp_Id")
@Expose
private Integer empId;
@SerializedName("Emp_First_Name")
@Expose
private String empFirstName;
@SerializedName("Emp_Last_Name")
@Expose
private String empLastName;
@SerializedName("Emp_Email")
@Expose
private String empEmail;
@SerializedName("Emp_Address")
@Expose
private String empAddress;
@SerializedName("Emp_Phone_No")
@Expose
private String empPhoneNo;
@SerializedName("Emp_Password")
@Expose
private String empPassword;
@SerializedName("Emp_Photo")
@Expose
private String empPhoto;
@SerializedName("Is_Resign")
@Expose
private Integer isResign;
@SerializedName("Joining_Date")
@Expose
private String joiningDate;
@SerializedName("Resign_Date")
@Expose
private String resignDate;
@SerializedName("sms_status")
@Expose
private Integer smsStatus;

public Integer getEmpId() {
return empId;
}

public void setEmpId(Integer empId) {
this.empId = empId;
}

public String getEmpFirstName() {
return empFirstName;
}

public void setEmpFirstName(String empFirstName) {
this.empFirstName = empFirstName;
}

public String getEmpLastName() {
return empLastName;
}

public void setEmpLastName(String empLastName) {
this.empLastName = empLastName;
}

public String getEmpEmail() {
return empEmail;
}

public void setEmpEmail(String empEmail) {
this.empEmail = empEmail;
}

public String getEmpAddress() {
return empAddress;
}

public void setEmpAddress(String empAddress) {
this.empAddress = empAddress;
}

public String getEmpPhoneNo() {
return empPhoneNo;
}

public void setEmpPhoneNo(String empPhoneNo) {
this.empPhoneNo = empPhoneNo;
}

public String getEmpPassword() {
return empPassword;
}

public void setEmpPassword(String empPassword) {
this.empPassword = empPassword;
}

public String getEmpPhoto() {
return empPhoto;
}

public void setEmpPhoto(String empPhoto) {
this.empPhoto = empPhoto;
}

public Integer getIsResign() {
return isResign;
}

public void setIsResign(Integer isResign) {
this.isResign = isResign;
}

public String getJoiningDate() {
return joiningDate;
}

public void setJoiningDate(String joiningDate) {
this.joiningDate = joiningDate;
}

public String getResignDate() {
return resignDate;
}

public void setResignDate(String resignDate) {
this.resignDate = resignDate;
}

public Integer getSmsStatus() {
return smsStatus;
}

public void setSmsStatus(Integer smsStatus) {
this.smsStatus = smsStatus;
}

}