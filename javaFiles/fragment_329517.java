int b;
while ((line2 = br2.readLine()) != null) {
    String a = Encode.encode(line2, hTree);

    while (a.length() % 8 != 0)
        a += "0"; // lets add some extra bits until we have full bytes
    for (int i = 0; i < a.length(); i += 8) {
        String byteString = a.substring(i, i + 8); // grab a byte
        int parsedByte = 0xFF & Integer.parseInt(byteString, 2);
        fos.write(parsedByte); // write a byte
    }

}