Stream stream = new NetworkStream(socket, FileAccess.ReadWrite, true);
BinaryWriter writer = new BinaryWriter(stream, Encoding.UTF8);

// Write double to the stream
long v = BitConverter.DoubleToInt64Bits(doubleValue);
writer.Write(IPAddress.HostToNetworkOrder(v));