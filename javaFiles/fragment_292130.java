package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {

@SerializedName("tcId")
@Expose
private String tcId;
@SerializedName("otpVerification")
@Expose
private String otpVerification;
@SerializedName("password")
@Expose
private String password;
@SerializedName("homePlace")
@Expose
private List<HomePlace> homePlace = null;

public String getTcId() {
return tcId;
}

public void setTcId(String tcId) {
this.tcId = tcId;
}

public String getOtpVerification() {
return otpVerification;
}

public void setOtpVerification(String otpVerification) {
this.otpVerification = otpVerification;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public List<HomePlace> getHomePlace() {
return homePlace;
}

public void setHomePlace(List<HomePlace> homePlace) {
this.homePlace = homePlace;
}

}