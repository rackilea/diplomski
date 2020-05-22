public class StringToColor implements Converter<String, Color> {
  public Color convert(String source) {
    if(source.equal("red") {
       return new Color("red");
    }

    if(source.equal("green") {
       return new Color("green");
    }

    if(source.equal("blue") {
       return new Color("blue");
    }

    // etc

    return null;
  }
}