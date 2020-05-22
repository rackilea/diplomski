import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "eventData")
public class EventData {

  private String name;

  private String data;

  @XmlElement(name = "data")
  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @XmlAttribute(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rtEvent")
public class RtEvent {

  private List<EventData> edataList;

  @XmlElement(name = "eventData")
  public List<EventData> getEdataList() {
    return edataList;
  }

  public void setEdataList(List<EventData> edataList) {
    this.edataList = edataList;
  }
}

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "output")
public class Output {

  private RtEvent rtEvent;

  public RtEvent getRtEvent() {
    return rtEvent;
  }

  public void setRtEvent(RtEvent rtEvent) {
    this.rtEvent = rtEvent;
  }

  public static void main(String[] args) {
    try {
      EventData eData1 = new EventData();
      eData1.setData("111111-000000-111111");
      eData1.setName("tcppayload");

      EventData eData2 = new EventData();
      eData2.setData("ABCD");
      eData2.setName("text");

      List<EventData> eDataList = new ArrayList<>();
      eDataList.add(eData1);
      eDataList.add(eData2);

      RtEvent rtEvent = new RtEvent();
      rtEvent.setEdataList(eDataList);

      Output output = new Output();
      output.setRtEvent(rtEvent);

      JAXBContext ctx = JAXBContext.newInstance(Output.class);
      Marshaller marshaller = ctx.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
      marshaller.marshal(output, System.out);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}