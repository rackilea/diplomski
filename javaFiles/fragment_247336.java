Document temp_person_doc = cursor.next();

// get the sub document _as a_ Document
Document temp_address_doc = temp_person_doc.get("address", Document.class);

// get the houseNo attribute (which is an integer) from the sub document
Integer houseNo = temp_address_doc.getInteger("houseNo");
// get the address attribute (which is a string) from the sub document
String address = temp_address_doc.getString("address");

// prints 742
System.out.println(houseNo);    
// prints evergreen terrace
System.out.println(address);