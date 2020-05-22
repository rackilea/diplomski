JSONtoVar jsonToVar=new JSONtoVar();
HashMap<String, String> mapJson=(HashMap<String, String>)jsonToVar.parseJson();

System.out.println("mapJson TenderType "+mapJson.get("TenderType"));
System.out.println("mapJson TenderAmount "+mapJson.get("TenderAmount"));
System.out.println("mapJson CrdName "+mapJson.get("CrdName"));