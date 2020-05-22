Stream stream = new NetworkStream(socket, FileAccess.ReadWrite, true);
BinaryReader reader = new BinaryReader(stream, Encoding.UTF8);   

// Read double from the stream
long v = IPAddress.NetworkToHostOrder(reader.ReadInt64());   
double doubleValue = BitConverter.Int64BitsToDouble(v);