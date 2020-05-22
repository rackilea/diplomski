package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComplaintProduct {

    @SerializedName("SequenceNo")
    @Expose
    private String sequenceNo;
    @SerializedName("SparepartId")
    @Expose
    private String sparepartId;
    @SerializedName("Quantity")
    @Expose
    private String quantity;
    @SerializedName("Group")
    @Expose
    private String group;
    @SerializedName("Model")
    @Expose
    private String model;

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getSparepartId() {
        return sparepartId;
    }

    public void setSparepartId(String sparepartId) {
        this.sparepartId = sparepartId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}