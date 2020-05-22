public class NullCharacterEscapeHandler implements CharacterEscapeHandler {

  public NullCharacterEscapeHandler() {
    super();
  }

  public void escape(char[] ch, int start, int length, boolean isAttVal, Writer writer) throws IOException {
    // Proxy the characters to the writer, with no encoding escape.
    writer.write( ch, start, length );
  }
}