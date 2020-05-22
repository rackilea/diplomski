package com.sof.test;

public class Car {
    private String model;
    private String version;
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object obj) {

        if(this.model.equals(((Car)obj).getModel())&&this.version.equals(((Car)obj).getVersion())){

            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {

        return  this.model.length()+this.version.length();
    }

    @Override
    public String toString() {

        return this.model+"\t "+this.version;
    }
}