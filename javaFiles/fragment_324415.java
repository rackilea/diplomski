ClientResource cr = new ClientResource("http://whois.arin.net/rest/poc/KOSTE-ARIN");
Representation repr = cr.get();
DomRepresentation dRepr = new DomRepresentation(repr);
Node firstNameNode = dRepr.getNode("//firstName");
Node lastNameNode = dRepr.getNode("//lastName");
System.out.println(firstNameNode.getTextContent()+" "+lastNameNode.getTextContent());