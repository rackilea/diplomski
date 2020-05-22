MagicMatch match = Magic.getMagicMatch(your_byte_array);
String mimeType = match.getMimeType();

if(mimeType.equals("image/x-emf")) {
    //here is emf
}
if(mimeType.equals("image/x-wmf")) {
    //here is wmf
}