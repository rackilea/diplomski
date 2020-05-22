ObjectMapper objectMapper = new ObjectMapper();
TypeFactory typeFactory = objectMapper.getTypeFactory();
JsonNode array = objectMapper.readValue(anotherResponseStr, JsonNode.class);
JsonNode paymentResponse = array.get("PaymentResponse[]");

List<PaymentResponse> p = objectMapper.readValue(paymentResponse.toString(), 
typeFactory.constructCollectionType(List.class, PaymentResponse.class));