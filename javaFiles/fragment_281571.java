public class Student {


 // private String id  .. maybe
private String name;
private String address;
private String gender;
private String dob;

//for clarity
public Student(){

}
public String getName() {
    return name;
}

public String getAddress() {
    return address;
}

public String getGender() {
    return gender;
}

public String getDob() {
    return dob;
}

public void setName(String name) {
   this.name=name;
}

public void setAddress(String address) {
  this.address=address;
}

public void setGender(String gender) {
    this.gender=gender;
}

public void setDob(String dob) {
   this.dob=dob;
}

}