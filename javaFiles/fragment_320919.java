interface Handler {
  void handle(NewClientPacket packet);
  void handle(DisconnectPacket packet);
  void handle(DataPacket packet);
}

interface Packet {
  void dispatch(Handler handler)
}

class NewClientPacket implements Packet {
  @Override
  public void dispatch(Handler handler) { 
    handler.handle(this);
  }
}

class DisconnectPacket implements Packet {
  @Override
  public void dispatch(Handler handler) { 
    handler.handle(this);
  }
}

class DataPacket implements Packet {
  @Override
  public void dispatch(Handler handler) { 
    handler.handle(this);
  }
}