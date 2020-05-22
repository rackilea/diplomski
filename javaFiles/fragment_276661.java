byte[] bytesDecoded = DatatypeConverter.parseBase64Binary(strEncoded);
int pkStart = -1;
for (int i = 0; i < (bytesDecoded.length - 1); i++) {
    if (bytesDecoded[i] == 0x50) {  // "P"
        if (bytesDecoded[i+1] == 0x4B) {  // "K"
            pkStart = i;
            break;
        }
    }
}
if (pkStart < 0) {
    System.out.println("Did not find 'PK' marker in decoded data.");
}
else {
    FileOutputStream fos = new FileOutputStream("C:\\Users\\Gord\\Desktop\\Hello.docx");
    fos.write(Arrays.copyOfRange(bytesDecoded, pkStart, bytesDecoded.length));
    fos.close();
}