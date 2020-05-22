package com.mobinet.snmp;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultTcpTransportMapping;

/**
 *
 * @author batbayar
 */
public class SnmpTest {
    private String address = "192.168.1.254/161"; // switch address and snmp port
    private String writeCommunity = "myCommunityWrite"; // write community name

    private Snmp snmp;
    private CommunityTarget target;

    public SnmpTest() {
        try {
            TransportMapping transport = new DefaultTcpTransportMapping();
            snmp = new Snmp(transport);

            Address targetAddress = GenericAddress.parse(address);
            target = new CommunityTarget();
            target.setCommunity(new OctetString(writeCommunity));
            target.setAddress(targetAddress);
            target.setRetries(2);
            target.setTimeout(1500);
            target.setVersion(SnmpConstants.version2c);

            PDU command = new PDU();
            command.setType(PDU.SET);
            command.add(new VariableBinding(new OID("1.3.6.1.2.1.2.2.1.7.1"), new Integer32(2))); // port 1 down
            command.add(new VariableBinding(new OID("1.3.6.1.2.1.2.2.1.7.6"), new Integer32(1))); // port 6 up
            ResponseEvent response = snmp.send(command, target);
            System.out.println("response: " + response);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SnmpTest test = new SnmpTest();
    }
}