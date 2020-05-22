package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomePlace {

@SerializedName("address")
@Expose
private String address;
@SerializedName("lat")
@Expose
private String lat;
@SerializedName("lng")
@Expose
private String lng;

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getLat() {
return lat;
}

public void setLat(String lat) {
this.lat = lat;
}

public String getLng() {
return lng;
}

public void setLng(String lng) {
this.lng = lng;
}

}