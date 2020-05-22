@Controller
public class BlobController {

    @RequestMapping("/download/{id}")
    public HttpEntity<byte[]> download(@PathVariable String id) {

        // JDBC code to retrieve the BLOB column
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT FILENAME, FILETYPE, CONTENT FROM MY TABLE WHERE ID = " + id);
        Blob blob = rs.getBlob("CONTENT");
        String fileName= rs.getString("FILENAME"); // ex. file1
        String fileType= rs.getString("FILETYPE"); // ex. pdf

        // Transform BLOB to Byte array
        int blobLength = (int) blob.length();  
        byte[] document = blob.getBytes(1, blobLength);


        // Set HTTP Header to force the browser to open the download popup
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", fileType));
        header.set("Content-Disposition", "attachment; filename=" + file1 + "." + fileType);
        header.setContentLength(blobLength );

        //release the blob and free up memory. (since JDBC 4.0)
        blob.free();

        return new HttpEntity<byte[]>(document, header);
    }
}