import sun.misc;

final int dwDataOffset = 0;
final int cbDataOffset = 4;  // Change to 8 for 64 bit
final int lpDataOffset = 8;  // Change to 16 for 64 bit

int cpDataAddr = this._pData.getValue();         // This will return the address of the struct (I assume this syntax is correct) - change to long for 64 bit
int messageCode= Unsafe.getInt(cpDataAddr+dwDataOffset);  // Change to getLong for 64 bit
int dataSize = Unsafe.getInt(cbDataAddr+cbDataOffset);
int dataAddress = Unsafe.GetInt(cbDataAddr+lpDataOffset); // Change to getLong for 64 bit

// Create a buffer to hold the data from lpData
byte[] data = new byte[dataSize];
for (int i = 0; i < dataSize; i++)
   data[i] = Unsafe.getByte(dataAddress+i);