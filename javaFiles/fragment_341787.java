public class ObjectModel {

String mobile_number = "";
String work_number = "";
String fax_number = "";
String first_name = "";
String last_name = "";
String website = "";
ArrayList<Email> email = new ArrayList<>();


public String getMobile_number() {
    return mobile_number;
}

public void setMobile_number(String mobile_number) {
    this.mobile_number = mobile_number;
}

public String getWork_number() {
    return work_number;
}

public void setWork_number(String work_number) {
    this.work_number = work_number;
}

public String getFax_number() {
    return fax_number;
}

public void setFax_number(String fax_number) {
    this.fax_number = fax_number;
}

public String getFirst_name() {
    return first_name;
}

public void setFirst_name(String first_name) {
    this.first_name = first_name;
}

public String getLast_name() {
    return last_name;
}

public void setLast_name(String last_name) {
    this.last_name = last_name;
}

public String getWebsite() {
    return website;
}

public void setWebsite(String website) {
    this.website = website;
}

public ArrayList<Email> getEmail() {
    return email;
}

public void setEmail(ArrayList<Email> email) {
    this.email = email;
}

public static class Email {
    String work = "";
    String personal = "";

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }
}