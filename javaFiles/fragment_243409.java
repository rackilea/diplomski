ZipArchiveOutputStream ostream = ...; // Your initialization code here
ostream.setEncoding("Cp437"); // This should handle your "special" characters
ostream.setFallbackToUTF8(true); // For "unknown" characters!
ostream.setUseLanguageEncodingFlag(true);                               
ostream.setCreateUnicodeExtraFields(
    ZipArchiveOutputStream.UnicodeExtraFieldPolicy.NOT_ENCODEABLE);