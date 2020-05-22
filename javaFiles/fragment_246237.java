package org.example.chad;

public class DataItem {
private String name;
private String record;

public DataItem(){

}

public DataItem(String n, String r ){
    this.name = n;
    this.record = r;
}

public String getname() {
    return name;
}

public void setname(String name) {
    this.name = name;
}

public String getrecord() {
    return record;
}

public void setrecord(String record) {
    this.record = record;
}