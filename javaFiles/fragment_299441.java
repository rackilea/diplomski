@Test
public void byteConsistency() {
  byte[] vals = new byte[] {0, 110, -1};
  ByteString original = ByteString.copyFrom(vals);
  ByteString newString = ByteString.copyFromUtf8(original.toStringUtf8());

  for (int index = 0; index < newString.size(); index++) {
    System.out.println(newString.byteAt(index));
  }
}