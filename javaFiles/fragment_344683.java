package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Member {

    @SerializedName("clanRank")
    @Expose
    private Integer clanRank;
    @SerializedName("crowns")
    @Expose
    private Integer crowns;
    @SerializedName("donations")
    @Expose
    private Integer donations;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("trophies")
    @Expose
    private Integer trophies;

    public Integer getClanRank() {
        return clanRank;
    }

    public void setClanRank(Integer clanRank) {
        this.clanRank = clanRank;
    }

    public Integer getCrowns() {
        return crowns;
    }

    public void setCrowns(Integer crowns) {
        this.crowns = crowns;
    }

    public Integer getDonations() {
        return donations;
    }

    public void setDonations(Integer donations) {
        this.donations = donations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getTrophies() {
        return trophies;
    }

    public void setTrophies(Integer trophies) {
        this.trophies = trophies;
    }

    @Override
    public String toString() {
        return "Member [clanRank=" + clanRank + ", crowns=" + crowns + ", donations=" + donations + ", name=" + name
                + ", tag=" + tag + ", trophies=" + trophies + "]";
    }

}