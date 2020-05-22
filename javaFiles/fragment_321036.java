import java.io.FileOutputStream;
import java.io.File;

import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;

public class WordReadAndReWrite {

 public static void main(String[] args) throws Exception {

  String filePath = "WordDocument.docx";
  String tmpFilePath = "~$WordDocument.docx";

  File file = Files.copy(Paths.get(filePath), Paths.get(tmpFilePath), StandardCopyOption.REPLACE_EXISTING).toFile();

  XWPFDocument doc = new XWPFDocument(OPCPackage.open(file));

  // Replace paragraphs.

  FileOutputStream out = new FileOutputStream(filePath); 
  doc.write(out);
  out.close();
  doc.close();

  Files.deleteIfExists(Paths.get(tmpFilePath));
 }

}