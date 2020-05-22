// Set java keystore manually
System.setProperty("javax.net.ssl.keyStore", KEYSTORE_DIR);
System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
System.setProperty("javax.net.ssl.trustStore", KEYSTORE_DIR);
System.setProperty("javax.net.ssl.trustStorePassword", "changeit");

// create the TLS transport mapping:
TLSTM transport = new TLSTM();

// set the security callback (only required for command responder,
// but also recommended for command generators) -
// the callback will be configured later:
DefaultTlsTmSecurityCallback securityCallback = new DefaultTlsTmSecurityCallback();
((TLSTM) transport).setSecurityCallback(securityCallback);
MessageDispatcher md = new MessageDispatcherImpl();
// we need MPv3 for TLSTM:
MPv3 mpv3 = new MPv3();
md.addMessageProcessingModel(mpv3);

Snmp snmp = new Snmp(md, transport);

// create and initialize the TransportSecurityModel TSM:
SecurityModels.getInstance().addSecurityModel(new TSM(new OctetString(mpv3.getLocalEngineID()), false));

// do not forget to listen for responses:
snmp.listen();

CertifiedTarget ct = new CertifiedTarget(new OctetString("alias"));
ct.setVersion(SnmpConstants.version3);
ct.setSecurityModel(SecurityModel.SECURITY_MODEL_TSM);
ct.setAddress(GenericAddress.parse(myAddress));
ct.setSecurityLevel(SecurityLevel.AUTH_PRIV);

securityCallback.addAcceptedSubjectDN("EMAILADDRESS=admin@net-snmp.org, CN=snmpagent, OU=Development, O=Net-SNMP, L=Davis, ST=CA, C=US");
securityCallback.addLocalCertMapping(ct.getAddress(), "snmpagentalias");

PDU pdu = new ScopedPDU();
pdu.add(new VariableBinding(new OID(someOid)));
pdu.setType(PDU.GET);

ResponseEvent response = snmp.send(pdu, ct);