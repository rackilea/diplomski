package com.example.bean;

public class FriendBean {
private String Image;
private String name;
private String ph;
private String des;

public FriendBean(String Image, String name, String ph, String des) {
    this.Image = Image;
    this.name = name;
    this.ph = ph;
    this.des = des;

}

public String getImage() {
    return Image;
}

public void setImage(String image) {
    Image = image;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getPh() {
    return ph;
}

public void setPh(String ph) {
    this.ph = ph;
}

public String getDes() {
    return des;
}

public void setDes(String des) {
    this.des = des;
}
}