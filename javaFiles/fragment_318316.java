public class Coordinates {
    byte red;

    @JsonProperty("r")
    public byte getR() {
      return red;
    }

    @JsonProperty("red")
    public void setRed(byte red) {
      this.red = red;
    }
}