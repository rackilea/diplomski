import java.io.File;
import java.io.IOException;
import de.idyl.winzipaes.AesZipFileEncrypter;
import de.idyl.winzipaes.impl.AESEncrypterBC;

public class Practice1Main {

public static void main(String[]args) throws IOException{


    File aNewZipFile = new File("src.zip");
    File existingUnzippedFile = new File("src.txt");

    AESEncrypterBC encrypter = new AESEncrypterBC();
    encrypter.init("password", 0);  // The 0 is keySize, it is ignored for AESEncrypterBC

    AesZipFileEncrypter zipEncrypter = new AesZipFileEncrypter(aNewZipFile, encrypter);

    zipEncrypter.add(existingUnzippedFile, "src.txt", "password");
    zipEncrypter.close();
   }
}