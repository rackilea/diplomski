int[] ivInInts = new int[] { 116,209,63,154,85,66,37,82,96,104,131,192,103,140,125,176 };

byte[] iv = new byte[ivInInts.getLength()];

for (int i = 0; i < ivInInts.getLength(); i++)
   iv = (byte)(ivInInts[i] - 128);