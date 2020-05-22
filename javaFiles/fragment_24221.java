/**
 * Call this method before attempting to append any tokens. This method
 * implementation <b>must</b> be called by any overridden version.
 */
@Override
public void prepareToWrite() {
  super.prepareToWrite();
  encodeBuffer = new StringBuilder();

  // Write serialization policy info
  writeString(moduleBaseURL);
  writeString(serializationPolicyStrongName);
}

@Override
public String toString() {
  StringBuilder buffer = new StringBuilder();
  writeHeader(buffer);
  writeStringTable(buffer);
  writePayload(buffer);
  return buffer.toString();
}