// GetSigPos.java 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
//import java.util.*;
import java.util.List;
//import java.awt.List;

class GetSigPos {
  public static void main(String[] args) throws IOException {
    String pdfFile = args[0];
    PdfReader reader = new PdfReader(pdfFile);

    AcroFields fields = reader.getAcroFields();

    for(String signame : fields.getBlankSignatureNames()) {
      List<AcroFields.FieldPosition> positions = fields.getFieldPositions(signame);
      Rectangle rect = positions.get(0).position; // In points:
      float left   = rect.getLeft();
      float bTop   = rect.getTop();
      float width  = rect.getWidth();
      float height = rect.getHeight();

      int page = positions.get(0).page;
      Rectangle pageSize = reader.getPageSize(page);
      float pageHeight = pageSize.getTop();
      float top = pageHeight - bTop;

      System.out.print(signame + "::" + page + "::" + left + "::" + top + "::" + width + "::" + height + "\n");
    }
  }
}