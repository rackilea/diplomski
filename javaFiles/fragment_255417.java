ByteArrayOutputStream bytes = new ByteArrayOutputStream();
DataOutputStream dataOut = new DataOutputStream(bytes);

dataOut.write('M');
dataOut.write('M');     // "Motorola" (network) byte order
dataOut.writeShort(42); // TIFF magic identifier (42)

dataOut.writeUnsignedInt(8); // Offset to 1st IFD

// ... write IFD, containing minimal info as per the spec