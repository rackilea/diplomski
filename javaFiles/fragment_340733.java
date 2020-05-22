import java.util.*;
import com.ibm.as400.access.*;
import com.ibm.as400.util.commtrace.*;

public class TestCommTrace {
    public static void main(String[] args) {

try {
 Format f = new Format("/buck/linetrace");

 FormatProperties fmtprop = new FormatProperties();
 f.setFilterProperties(fmtprop); // Sets the filtering properties for this Format

 f.formatProlog(); // Format the prolog
 Prolog pro = f.getProlog();    
 System.out.println(pro.toString());

 if(!pro.invalidData()) { // This is not a valid trace
         Frame rec; 
         while((rec=f.getNextRecord())!=null) { // Get the records
                System.out.print("Frame " + rec.getRecNum().toString()); // Print out the Frame Number
                System.out.println(" time " + rec.getTime().toString()); // Print out the time
                IPPacket p = rec.getPacket(); // Get this records packet
                Header h = p.getHeader(); // Get the first header
                if(p.getType()==IPPacket.IP4) { // If IP4 IPPacket
                        if(h.getType()==Header.IP4) { // If IP4 Header
                                IP4Header ip4 = (IP4Header) h; // Cast to IP4 so we can access methods
                                System.out.println(h.getName()); // Print the name
                                System.out.println("IP4 src:"+ip4.getSrcAddr() + " dst:" + ip4.getDstAddr());
                                System.out.println(ip4.printHexHeader()); // Print the header as hex 
                                // Print a string representation of the header.
                                System.out.println(ip4.toString()); // hex string
                                //System.out.println(ip4.toString(fmtprop)); // very detailed
                                while((h=h.getNextHeader())!=null) { // Get the rest of the headers
                                        if(h.getType()==Header.TCP) { // If its a TCP header
                                                TCPHeader tcp = (TCPHeader) h; // Cast so we can access methods
                                                System.out.println("TCP src:" + tcp.getSrcPort() + " dst:" + tcp.getDstPort() + " checksum:" + tcp.getCheckSum()); 
                                                System.out.println(tcp.toString());  // hex string
                                                //System.out.println(tcp.toString(fmtprop));  // very detailed

                                        } else if(h.getType()==Header.UDP) { // If its a UDP header
                                                UDPHeader udp = (UDPHeader) h; // Cast so we can access methods
                                                System.out.println("UDP src:" + udp.getSrcPort() + " dst:" + udp.getDstPort()); 
                                                System.out.println(udp.toString());
                                        }
                                }
                        }
                }
         } 

 f.close();
 }      
    } catch (Exception e) {
      e.printStackTrace();
    }
}

}