import java.io.*;

class TestBinaryFileReading {

  static public void main(String[] args) throws IOException {  
    DataInputStream data_in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream(new File("binary_file.dat"))));
    while(true) {
      try {
        int t = data_in.readInt();//read 4 bytes

        System.out.printf("%08X ",t); 

        // change endianness "manually":
        t = (0x000000ff & (t>>24)) | 
            (0x0000ff00 & (t>> 8)) | 
            (0x00ff0000 & (t<< 8)) | 
            (0xff000000 & (t<<24));
        System.out.printf("%08X",t); 
        System.out.println();
      } 
      catch (java.io.EOFException eof) {
        break;
      }
    } 
    data_in.close();
  }
}