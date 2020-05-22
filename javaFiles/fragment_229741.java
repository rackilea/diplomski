public RoomView(RoomPController newRpc, String newRoomName) {
    setPreferredSize(new Dimension(600,350));
    rpc = newRpc;
    w = 0;
    h = 0;
    qFactor = 1;
    v = new Vector();
    roomName = newRoomName;
    getPreferredSize();
}