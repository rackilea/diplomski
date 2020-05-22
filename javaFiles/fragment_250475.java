try {
            Address targetAddress = GenericAddress.parse("udp:"+serverIp+"/162");
            TransportMapping    transport = new DefaultUdpTransportMapping();
            transport.listen();
            Snmp snmp = new Snmp(transport);

            CommunityTarget target = new CommunityTarget();
            target.setCommunity(new OctetString("public"));
            target.setAddress(targetAddress);
            target.setVersion(SnmpConstants.version2c);

            PDUv1 pdu = new PDUv1();
            pdu.setType(PDU.TRAP);

            OID trap = new OID("1.3.6.1.6.3.1.1.4.1.0");
            VariableBinding vb = new VariableBinding();
            vb.setOid(trap);
            vb.setVariable(new OctetString("1.3.6.1.4.1.9.9.46.2.0.11"));//11,10
            pdu.add(vb);


            VariableBinding vb2 = new VariableBinding();
            vb2.setOid(new OID("1.3.6.1.4.1.9.9.46.1.3.1.1.4.1.80"));
            vb2.setVariable(new OctetString("VLAN0080"));
            pdu.add(vb2);

            snmp.send(pdu, target);         
} catch (IOException e) {
            e.printStackTrace();
}