json = (json data)
JsonParser parser = new JsonParser();
JsonObject rootObj = parser.parse(json).getAsJsonObject();
JsonArray paymentsArray = rootObj.getAsJsonArray("payments");
for (JsonElement pa : paymentsArray) {
    JsonObject paymentObj = pa.getAsJsonObject();
    String     quoteid     = paymentObj.get("quoteid").getAsString();
    String     dateEntered = paymentObj.get("date_entered").getAsString();
    BigDecimal amount      = paymentObj.get("amount").getAsBigDecimal();
}