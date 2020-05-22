package com.collegewires.jackson;

import java.util.List;

public class Entries{
    private String address;
    private String email;
    private String gender;
    private String id;
    private String name;
    private Phone phone;

    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Phone getPhone(){
        return this.phone;
    }
    public void setPhone(Phone phone){
        this.phone = phone;
    }
}