import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Students {

  String id;
  String firstName;
  String lastName;
  String email;
  String gender;
  String ipAddress;
  List < Websites > websitesVisited;
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public String getIpAddress() {
    return ipAddress;
  }
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }
  public List < Websites > getWebsitesVisited() {
    return websitesVisited;
  }
  public void setWebsitesVisited(List < Websites > websitesVisited) {
    this.websitesVisited = websitesVisited;
  }
  @Override
  public String toString() {
    return "Students [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email +
      ", gender=" + gender + ", ipAddress=" + ipAddress + ", websitesVisited=" + websitesVisited + "]";
  }



}