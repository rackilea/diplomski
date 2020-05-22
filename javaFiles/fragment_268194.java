public static void main(String[] args) {
    JsonArray jsonArray = new JsonArray();
    SmsToSend smsToSend1 = new SmsToSend(1,526833,"Test1");
    SmsToSend smsToSend2 = new SmsToSend(2,526834,"Test2");
    jsonArray.add(new Gson().toJsonTree(smsToSend1));
    jsonArray.add(new Gson().toJsonTree(smsToSend2));
    String jsonResp = jsonArray.toString();
    System.out.println(jsonResp);
}