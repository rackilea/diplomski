public class CrLfProcessor implements ByteBufProcessor{
  private byte previousByte;

  @Override
  public boolean process(byte value) {
    if(previousByte == '\r'){
      if(value == '\n'){
        return false;
      }
    }

    previousByte = value;
    return true;
  }
}