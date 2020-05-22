ByteBuffer b = ByteBuffer.allocate(28);
b.order(ByteOrder.BIG_ENDIAN);

// header layout
byte addressed_center = 1;
byte record_version = 2;
int num_records = 1;
int buffer_used = 100;
long address = client_data((byte) 10, (short) 12, (byte) 30, (in) 200);
long address_from = client_data((byte) 20, (short) 22, (byte) 40, (int) 150);
byte records_partition = 10;
byte already_replicated = 20;

b.put(     addressed_center);
b.put(     record_version);
b.putInt(  num_records);
b.putInt(  buffer_used);
b.putLong( address);
b.putLong( address_from);
b.put(     records_partition);
b.put(     already_replicated);

byte[] result = b.array();
System.out.println(result);