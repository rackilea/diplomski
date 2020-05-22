// Format is: [length][7 data bytes][8 bit additive checksum]
// Create an empty byte array
byte[] packet = new byte[8];

// Our simple header
packet[0] = packet.length;

// Some data
byte[] dummyData = new byte[] { 1, 2, 3, 4, 5, 6, 7 };

// Copy data to packet
System.arraycopy(dummyData, 0, packet, 0, dummyData.length);

// Go do the checksum (good exercise for you)
byte checksum = getChecksum(packet);
packet[7] = checksum;