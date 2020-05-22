// The common interface. Every struct knows how to read and write itself.
public interface MultiStruct {
  public void readData(InputStream in);
  public void writeData(OutputStream out);
}

// This class knows only about storing a format code
public abstract class AbstractMultiStruct implements MultiStruct {
  protected static final int FORM1 = 1, FORM2 = 2;

  private int format;

  public AbstractMultiStruct(int fmt) {
    this.format = fmt;
  }

  public int getFormat() {
    return this.format;
  }

}

// This is the first real struct implementation.
public class Struct1 extends AbstractMultiStruct {
  private char[] dataA;
  private char[] dataB;

  public Struct1() {
    super(FORM1);
    this.dataA = new char[22];
    this.dataB = new char[33];
  }

  public void readData(InputStream in) {
    ...
  }

  public void writeData(OutputStream out) {
    ...
  }

  public String toString() {
    ...
  }


}