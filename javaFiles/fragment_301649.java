ByteBuffer out = ...

int oldPos = out.position(); // Remember current position.
out.position(oldPos + 2); // Leave space for message length (unsigned short)

out.putInt(...); // Write out data.

// Finally prepend buffer with number of bytes.
out.putShort(oldPos, (short)(out.position() - (oldPos + 2)));