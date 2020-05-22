// Split token into parts (parts are separated with '.'
final String[] tokenParts = token.split("\\.");

// decode payload part
final String decodedPayload =
    new String(Base64.getDecoder().decode(tokenParts[1]), "UTF-8");

// enrich payload with additional userName field by adding it to the end of
// JSON. Remove the last character which is '}' and append data as String
final String updatedDecodedPayload =
    decodedPayload.substring(0, decodedPayload.length() - 1)
    + ",\"userName\":\"" + "Richard" + "\"}";


// update payload with userId field and encode it back to base64
tokenParts[1] = Base64.getEncoder().encodeToString(
    updatedDecodedPayload.getBytes()
);

final String updatedToken = String.join(".", tokenParts));