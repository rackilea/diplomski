@Getter @Setter private InputStream inputStream;
@Getter private String yourContentType;
@Getter private String yourFileName;

public String execute() throws Exception {

   yourContentType = "audio/mpeg";
   yourFileName = "yourStuff.mp3";
   byte[] yourContent = loadTheContentInSomeWay();

   setInputStream(new ByteArrayInputStream(yourContent));        

   return SUCCESS;
}