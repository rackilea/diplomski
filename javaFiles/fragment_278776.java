byte[] array_1 = new byte[] { 1, 0, 1, 0, 1, 1 };
byte[] array_2 = new byte[] { 1, 0, 0, 1, 0, 1 };

byte[] array_3 = new byte[6];

int i = 0;
for (byte b : array_1)
    array_3[i] = b ^ array_2[i++];