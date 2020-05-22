@Action(value="getFile", results= {  
        @Result(name="ok", type="stream", params = {
                "contentType", "application/octet-stream",
                "inputName", "fileInputStream",
                "contentDisposition", "filename=\"${fileName}\"",
                "bufferSize", "1024"
        }) }
)   

@ParentPackage("default")
public class GetFileAction extends BasicActionClass {
    private String fileName;
    private Integer idFile;
    private ProgressAwareInputStream fileInputStream;

    public String execute () {
        cmabreu.sagitarii.persistence.entity.File file = null;

        try {
            FileService fs = new FileService();
            if ( (idFile != null) && ( idFile > -1 ) ) {
                file = fs.getFile( idFile );
            }

            if ( file != null ) {
                fileName = file.getFileName();
                byte[] theFile = file.getFile();

                ProgressAwareInputStream pais = new ProgressAwareInputStream( new ByteArrayInputStream( theFile ), 
                        theFile.length, fileName );

                pais.setOnProgressListener( new ProgressListener() );

                fileInputStream = pais; 

            } else {
                //
            }

        } catch ( Exception e ) {
            //
        }

        return "ok";
    }

    ... getters and setters .

}