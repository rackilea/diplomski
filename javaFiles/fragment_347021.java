Pointer p = new Memory();
byte[] data = ...;
// Copy into Memory from data
p.write(0, data, 0, data.length);
// Copy out of Memory into data
p.read(0, data, 0, data.length);