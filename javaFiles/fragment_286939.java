byte version = 1;
short message_length = 72;
short sub_version = 15346;
byte message_id = 2;
int flag1 = 10;
int flag2 = 0;
int flag3 = 0;
int flag4 = 0;
String message = "the quick brown fox jumps over the lazy dog";
ByteBuffer messageBuffer = ByteBuffer.allocate(message_length);

messageBuffer.put(version).putShort(message_length).putShort(sub_version).put(message_id).putInt(flag1).putInt(flag2).putInt(flag3).putInt(flag4).put(message.getBytes());

byte[] myArray = messageBuffer.array();