@Test
public void testHashContents() {//TODO: Fix
    when(nA.getProperty(PacketWrapper.KEY_CONTENTS)).thenReturn(new byte[] {1});
    packetA.hashContents();
    int hash = packetA.getContents().hashCode();
    verify(nA).setProperty(PacketWrapper.KEY_CONTENTS, hash);
    verify(nA).setProperty(PacketWrapper.IS_HASH, true);
}