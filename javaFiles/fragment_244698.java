int start;
do
{
    start = din.read();
} while (start != -1 && start != 0x68);
if (start == -1)
    throw new EOFException();
int length = din.readUnsignedByte();
byte[] message = new byte[length];
din.readFully(message);
return message;