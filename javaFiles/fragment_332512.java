package com.example.dto;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
public class Computer {

    private String hostname;
    private String vendor;
    private String model;
    private int swap;
    private int memory;
    @JsonProperty("sess_count")
    private int sessCount;
    private List<Load> load;
    @JsonProperty("in_use")
    private boolean inUse;
    @JsonProperty("free_in_tmp")
    private int freeInTmp;
    @JsonProperty("class")
    private String clazz;
    private List<Location> location;
    @JsonProperty("last_access")
    private String lastAccess;
    @JsonProperty("last_report")
    private int lastReport;
    private String ip;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSwap() {
        return swap;
    }

    public void setSwap(int swap) {
        this.swap = swap;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getSessCount() {
        return sessCount;
    }

    public void setSessCount(int sessCount) {
        this.sessCount = sessCount;
    }

    public List<Load> getLoad() {
        return load;
    }

    public void setLoad(List<Load> load) {
        this.load = load;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public int getFreeInTmp() {
        return freeInTmp;
    }

    public void setFreeInTmp(int freeInTmp) {
        this.freeInTmp = freeInTmp;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }

    public String getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(String lastAccess) {
        this.lastAccess = lastAccess;
    }

    public int getLastReport() {
        return lastReport;
    }

    public void setLastReport(int lastReport) {
        this.lastReport = lastReport;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        String str = "=================================\r\n";
        str += "Hostname: " + hostname + "\r\n" +
                "Vendor: " + vendor + "\r\n" + 
                "Model: " + model + "\r\n" +
                "Swap: " + swap + "\r\n" +
                "Memory: " + memory + "\r\n" +
                "Sess_Count: " + sessCount + "\r\n" +
                "Load: " + "\r\n";

        for(Load ld : load) {
            str += "\t" + "One: " + ld.getOne() + "\r\n";
            str += "\t" + "Five: " + ld.getFive() + "\r\n";
            str += "\t" + "Fifteen: " + ld.getFifteen() + "\r\n";
        }

        str += "In_Use: " + inUse + "\r\n" +
                "Free_In_Tmp: " + freeInTmp + "\r\n" +
                "Class: " + clazz + "\r\n" +
                "Location: " + "\r\n";

        for(Location lc : location) {
            str += "\t" + "Building: " + lc.getBuilding() + "\r\n";
            str += "\t" + "Computers: " + lc.getComputers() + "\r\n";
            str += "\t" + "Room: " + lc.getRoom() + "\r\n";
            str += "\t" + "String: " + lc.getStr() + "\r\n";
        }

        str += "Ip: " + ip + "\r\n";
        str += "Last_Access: " + lastAccess + "\r\n";
        str += "Last_Report: " + lastReport + "\r\n";

        return str;     
    }
}