import java.io.StringReader;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        String xml = "<?xml version='1.0' encoding='UTF-8'?><Ticket><bookedSeats>3</bookedSeats><bpAddress>Anand Rao Circle</bpAddress><bpLandMark>ganesha temple</bpLandMark><bpLocation> Ghousia College</bpLocation><bpPhoneNo>98798679769</bpPhoneNo><bpTime>1200</bpTime><busServiceName>efdf</busServiceName><busType>Volvo A/C Semi Sleeper (2+2)</busType><commission>66.19</commission><dateOfJourney>2012-10-05</dateOfJourney><destination>Chennai</destination><fare>600.0</fare><issueTime>2012-10-04T15:46:45.073+05:30</issueTime><noOfSeats>1</noOfSeats><passengerMobile>1234567890</passengerMobile><passengerName>Test</passengerName><pnr>RATPKES44974756</pnr><seatDetails><seatDetail><commission>66.19</commission><fare>600.0</fare><gender>MALE</gender><passengerAge>0</passengerAge><passengerMobile>1234567890</passengerMobile><passengerName>Test</passengerName><prime>false</prime><seatName>3</seatName></seatDetail></seatDetails><source>Bangalore</source><status>BOOKED</status><travelsName>Rajratan Travels</travelsName></Ticket>";

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();

        InputSource inputSource = new InputSource(new StringReader(xml));
        String pnr = (String) xpath.evaluate("/Ticket/pnr", inputSource, XPathConstants.STRING);
        System.out.println(pnr);
    }

}