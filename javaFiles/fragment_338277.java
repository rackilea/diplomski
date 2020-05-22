byte[] bytes = { (byte) 244, 12, 13, (byte) 155 }; // an example input

int[] ip = new int[4];
for(int i = 0; i < bytes.length; i++) {
    ip[i] = Byte.toUnsignedInt(bytes[i]);
}

System.out.println(Arrays.toString(bytes)); // [-12, 12, 13, -101]
System.out.println(Arrays.toString(ip)); // [244, 12, 13, 155]