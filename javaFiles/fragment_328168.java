ByteBuffer b = ByteBuffer.allocate(m_head_offset);
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

b.put(     m_off_addressed_center,   addressed_center);
b.put(     m_off_record_version,     record_version);
b.putInt(  m_off_num_records,        num_records);
b.putInt(  m_off_buffer_used,        buffer_used);
b.putLong( m_off_address,            address);
b.putLong( m_off_address_from,       address_from);
b.put(     m_off_records_partition,  records_partition);
b.put(     m_off_already_replicated, already_replicated);

byte[] result = b.array();
System.out.println(result);