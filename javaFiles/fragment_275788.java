package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class D {

    @SerializedName("ComplaintNo")
    @Expose
    private String complaintNo;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("UpdateDate")
    @Expose
    private String updateDate;
    @SerializedName("UpdateTime")
    @Expose
    private String updateTime;
    @SerializedName("ComplaintReason")
    @Expose
    private String complaintReason;
    @SerializedName("ClosureType")
    @Expose
    private String closureType;
    @SerializedName("Ibase")
    @Expose
    private String ibase;
    @SerializedName("Component")
    @Expose
    private String component;
    @SerializedName("ProductId")
    @Expose
    private String productId;
    @SerializedName("ProductDescription")
    @Expose
    private String productDescription;
    @SerializedName("Identification")
    @Expose
    private String identification;
    @SerializedName("Cat1")
    @Expose
    private String cat1;
    @SerializedName("Cat2")
    @Expose
    private String cat2;
    @SerializedName("Cat3")
    @Expose
    private String cat3;
    @SerializedName("StatusReason")
    @Expose
    private String statusReason;
    @SerializedName("VisitDate")
    @Expose
    private String visitDate;
    @SerializedName("VisitTime")
    @Expose
    private String visitTime;
    @SerializedName("NoOfVisit")
    @Expose
    private String noOfVisit;
    @SerializedName("SerialNo")
    @Expose
    private String serialNo;
    @SerializedName("OtherSpecify")
    @Expose
    private String otherSpecify;
    @SerializedName("Complaint_product")
    @Expose
    private List<ComplaintProduct> complaintProduct = null;
    @SerializedName("Complaint_retuarn")
    @Expose
    private List<ComplaintRetuarn> complaintRetuarn = null;

    public String getComplaintNo() {
        return complaintNo;
    }

    public void setComplaintNo(String complaintNo) {
        this.complaintNo = complaintNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getComplaintReason() {
        return complaintReason;
    }

    public void setComplaintReason(String complaintReason) {
        this.complaintReason = complaintReason;
    }

    public String getClosureType() {
        return closureType;
    }

    public void setClosureType(String closureType) {
        this.closureType = closureType;
    }

    public String getIbase() {
        return ibase;
    }

    public void setIbase(String ibase) {
        this.ibase = ibase;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public String getCat3() {
        return cat3;
    }

    public void setCat3(String cat3) {
        this.cat3 = cat3;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getNoOfVisit() {
        return noOfVisit;
    }

    public void setNoOfVisit(String noOfVisit) {
        this.noOfVisit = noOfVisit;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getOtherSpecify() {
        return otherSpecify;
    }

    public void setOtherSpecify(String otherSpecify) {
        this.otherSpecify = otherSpecify;
    }

    public List<ComplaintProduct> getComplaintProduct() {
        return complaintProduct;
    }

    public void setComplaintProduct(List<ComplaintProduct> complaintProduct) {
        this.complaintProduct = complaintProduct;
    }

    public List<ComplaintRetuarn> getComplaintRetuarn() {
        return complaintRetuarn;
    }

    public void setComplaintRetuarn(List<ComplaintRetuarn> complaintRetuarn) {
        this.complaintRetuarn = complaintRetuarn;
    }

}