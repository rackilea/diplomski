package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("donations")
    @Expose
    private Integer donations;
    @SerializedName("memberCount")
    @Expose
    private Integer memberCount;
    @SerializedName("members")
    @Expose
    private List<Member> members = null;

    public Integer getDonations() {
        return donations;
    }

    public void setDonations(Integer donations) {
        this.donations = donations;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Example [donations=" + donations + ", memberCount=" + memberCount + ", members=" + members + "]";
    }

}