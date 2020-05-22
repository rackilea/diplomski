String customerID = "the customer's id";
long time = DateTime.now().getMillis();
int myValue = 1;

Map<String, ByteBuffer> key = new Map<String, ByteBuffer>();
key.put("customer_id",ByteBufferUtil.bytes(customerID));
key.put("time",ByteBufferUtil.bytes(time));

List<ByteBuffer> values = Collections.singletonList(ByteBufferUtil.bytes(myValue));

context.write(key, values);