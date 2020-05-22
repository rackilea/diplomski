String testData="String Notify : {\"id\": \"1234\", \"transactionId\": \"TR-001\", \"timestamp\": \"1575445871\"} with result success";
int jsonStart=testData.indexOf('{');
int jsonEnd=testData.lastIndexOf('}')+1;
if(jsonStart>=0 && jsonEnd>jsonStart) {
    String jsonPart=testData.substring(jsonStart,jsonEnd);
    System.out.println(jsonPart);
}