import java.io.*;

import org.apache.poi.*;
import org.apache.poi.openxml4j.opc.*;
import org.apache.xmlbeans.*;

import org.apache.poi.xwpf.usermodel.*;

import static org.apache.poi.POIXMLTypeLoader.DEFAULT_XML_OPTIONS;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import javax.xml.namespace.QName;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.Locale;


public class CreateWordWithComments {

//a method for creating the CommentsDocument /word/comments.xml in the *.docx ZIP archive  
 private static MyXWPFCommentsDocument createCommentsDocument(XWPFDocument document) throws Exception {
  OPCPackage oPCPackage = document.getPackage();
  PackagePartName partName = PackagingURIHelper.createPartName("/word/comments.xml");
  PackagePart part = oPCPackage.createPart(partName, "application/vnd.openxmlformats-officedocument.wordprocessingml.comments+xml");
  MyXWPFCommentsDocument myXWPFCommentsDocument = new MyXWPFCommentsDocument(part);

  String rId = "rId" + (document.getRelationParts().size()+1);
  document.addRelation(rId, XWPFRelation.COMMENT, myXWPFCommentsDocument);

  return myXWPFCommentsDocument;
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  MyXWPFCommentsDocument myXWPFCommentsDocument = createCommentsDocument(document);

  CTComments comments = myXWPFCommentsDocument.getComments();
  CTComment ctComment;
  XWPFParagraph paragraph;
  XWPFRun run;

//first comment
  BigInteger cId = BigInteger.ZERO;

  ctComment = comments.addNewComment();
  ctComment.setAuthor("Axel Ríchter");
  ctComment.setInitials("AR");
  ctComment.setDate(new GregorianCalendar(Locale.US));
  ctComment.addNewP().addNewR().addNewT().setStringValue("The first comment.");
  ctComment.setId(cId);

  paragraph = document.createParagraph();
  paragraph.getCTP().addNewCommentRangeStart().setId(cId);

  run = paragraph.createRun();
  run.setText("Paragraph with the first comment.");

  paragraph.getCTP().addNewCommentRangeEnd().setId(cId);

  paragraph.getCTP().addNewR().addNewCommentReference().setId(cId);

//paragraph without comment
  paragraph = document.createParagraph();
  run = paragraph.createRun();
  run.setText("Paragraph without comment.");

//second comment
  cId = cId.add(BigInteger.ONE);

  ctComment = comments.addNewComment();
  ctComment.setAuthor("Axel Ríchter");
  ctComment.setInitials("AR");
  ctComment.setDate(new GregorianCalendar(Locale.US));
  ctComment.addNewP().addNewR().addNewT().setStringValue("The second comment.");
  ctComment.setId(cId);

  paragraph = document.createParagraph();
  paragraph.getCTP().addNewCommentRangeStart().setId(cId);

  run = paragraph.createRun();
  run.setText("Paragraph with the second comment.");

  paragraph.getCTP().addNewCommentRangeEnd().setId(cId);

  paragraph.getCTP().addNewR().addNewCommentReference().setId(cId);

//write document
  document.write(new FileOutputStream("CreateWordWithComments.docx"));
  document.close();

 }

//a wrapper class for the CommentsDocument /word/comments.xml in the *.docx ZIP archive
 private static class MyXWPFCommentsDocument extends POIXMLDocumentPart {

  private CTComments comments;

  private MyXWPFCommentsDocument(PackagePart part) throws Exception {
   super(part);
   comments = CommentsDocument.Factory.newInstance().addNewComments();
  }

  private CTComments getComments() {
   return comments;
  }

  @Override
  protected void commit() throws IOException {
   XmlOptions xmlOptions = new XmlOptions(DEFAULT_XML_OPTIONS);
   xmlOptions.setSaveSyntheticDocumentElement(new QName(CTComments.type.getName().getNamespaceURI(), "comments"));
   PackagePart part = getPackagePart();
   OutputStream out = part.getOutputStream();
   comments.save(out, xmlOptions);
   out.close();
  }

 }
}