/**
 * Decodes the Base64 part to bytes.
 * 
 * @param img An inline data encoded in Base64 like <code>"data:image/jpeg;base64,/9j/4AAQSkZJRg..."</code>.
 * 
 * @return Decoded data part
 */
public static byte[] parseImageString(String img) {
  // Avoid a NPE
  if(img == null) {
    return null;
  }

  // Use only the part after the comma
  final int pos = img.indexOf(',');
  if(pos >= 0) {
    final String base64Part = img.substring(pos + 1);
    final Base64.Decoder base64Decoder = Base64.getDecoder();
    return base64Decoder.decode(base64Part);
  } else {
    return null;
  }
}