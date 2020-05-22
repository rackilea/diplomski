public class Response {

private String partnerId;
private byte branchId;
private long customerNumber;
private Long subAccountNumber;
private Byte productType;
private String openingDate;
private String closingDate;
private List<BranchCustomers> branchCustomers;


public String getProductId() {
    return partnerId;
}

public void setProductId(String productid) {
    this.partnerId = productid;
}

public byte getBranchId() {
    return branchId;
}

public void setBranchId(byte branchid) {
    this.branchId = branchid;
}

public long getCustomerNumber() {
    return customerNumber;
}

public void setCustomerNumber(long customernumber) {
    this.customerNumber = customernumber;
}
...