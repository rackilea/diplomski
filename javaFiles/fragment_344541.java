public class DataHolder {

private static DataHolder mInstance;
private String name, idNumber, dob, address, planType; //fields you want

//add all the fields you want--like email,phoneNUmber,etc.,

public static DataHolder getInstance() {
    if (mInstance == null)
        return mInstance = new DataHolder();
    else
        return mInstance;
}

//getters and setters for the fields

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public String getDob() {
    return dob;
}

public void setDob(String dob) {
    this.dob = dob;
}

public String getIdNumber() {
    return idNumber;
}

public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getPlanType() {
    return planType;
}

public void setPlanType(String planType) {
    this.planType = planType;
}

//define getters and setters for all defined fields
}