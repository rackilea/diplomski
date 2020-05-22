import java.io.File;
import com.ibm.xsp.component.UIFileuploadEx.UploadedFile;
import com.ibm.xsp.http.IUploadedFile;
import lotus.domino.Database;
import lotus.domino.Document;
import lotus.domino.RichTextItem;
import com.ibm.xsp.extlib.util.ExtLibUtil;  //only used here to get the current db

public void saveMyBean() {

  if (uploadedFile != null ) {

        //get the uploaded file
        IUploadedFile iUploadedFile = uploadedFile.getUploadedFile();

        //get the server file (with a cryptic filename)
        File serverFile = iUploadedFile.getServerFile();        

        //get the original filename
        String fileName = iUploadedFile.getClientFileName();    

        File correctedFile = new File( serverFile.getParentFile().getAbsolutePath() + File.separator + fileName );

        //rename the file to its original name
        boolean success = serverFile.renameTo(correctedFile);

        if (success) {
            //do whatever you want here with correctedFile

            //example of how to embed it in a document:
            Database dbCurrent = ExtLibUtil.getCurrentDatabase();
            Document doc = dbCurrent.createDocument();
            RichTextItem rtFiles = doc.createRichTextItem("files");
            rtFiles.embedObject(lotus.domino.EmbeddedObject.EMBED_ATTACHMENT, "", correctedFile.getAbsolutePath(), null);
            doc.save();

            rtFiles.recycle();
            doc.recycle();

            //if we're done: rename it back to the original filename, so it gets cleaned up by the server
            correctedFile.renameTo( iUploadedFile.getServerFile() );
        }


    }
 }