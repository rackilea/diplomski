DatagramConnection dgConn; 
dgConn = (DatagramConnection)Connector.open("sms://" + _cntctsNmbrs.elementAt(i));
byte[] data = "MessageBody".getBytes();
Datagram dg = dgConn.newDatagram(dgConn.getMaximumLength());
dg.setData(data, 0, data.length);
dgConn.send(dg);