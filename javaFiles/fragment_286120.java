byte[] packet = new byte[packetLength];
int offset = 0;
while (offset < packetLength) {
    int bytesRead = in.read(packet, offset, packetLength - offset);
    if (bytesRead == -1) { 
        // Incomplete packet - handle however you want to
    }
    offset += bytesRead;
}
// Hooray - read the complete packet.