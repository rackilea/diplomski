@Entity
public class Example {

   // replace @Lob field with

   @ContentId
   private String contentId;

   @ContentLength
   private long contentLength = 0L;

   // if you have rest endpoints
   @MimeType
   private String mimeType = "text/plain";