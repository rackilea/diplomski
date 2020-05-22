import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Websites {

  String websiteName;
  String ipAddress;
  String timeSpent;
  String NoOfTimeVisitedInDay;

  public Websites() {

  }

  public String getWebsiteName() {
    return websiteName;
  }
  public void setWebsiteName(String websiteName) {
    this.websiteName = websiteName;
  }
  public String getIpAddress() {
    return ipAddress;
  }
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }
  public String getTimeSpent() {
    return timeSpent;
  }
  public void setTimeSpent(String timeSpent) {
    this.timeSpent = timeSpent;
  }
  public String getNoOfTimeVisitedInDay() {
    return NoOfTimeVisitedInDay;
  }
  public void setNoOfTimeVisitedInDay(String noOfTimeVisitedInDay) {
    NoOfTimeVisitedInDay = noOfTimeVisitedInDay;
  }

  @Override
  public String toString() {
    return "Websites [websiteName=" + websiteName + ", ipAddress=" + ipAddress + ", timeSpent=" + timeSpent +
      ", NoOfTimeVisitedInDay=" + NoOfTimeVisitedInDay + "]";
  }



}