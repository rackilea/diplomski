final int rateLimit = 50; // Bytes per second

final float msPerByte = 1000.0f / rateLimit;

writer.write(message);

int numBytes = message.length();

Thread.sleep((int)(msPerByte * numBytes + 1));