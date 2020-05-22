import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

@MultipartConfig // So you can call getPart(...) in doPost(...)
public class SupportFileUpload extends HttpServlet {

    private String uploadDirectory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // Configure location with <init-param> in web.xml
        uploadDirectory = config.getInitParameter("upload_directory");
        if (uploadDirectory == null) {
            uploadDirectory = System.getProperty("java.io.tmpdir");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getHeader("token");
        if (!isValid(token)) {
            response.setStatus(403);
            response.getWriter().println("Rejected");
            return;
        }
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        UUID uuid = UUID.randomUUID();
        filePart.write(Paths.get(uploadDirectory, "support_" + uuid + "_" + fileName).toString());
        response.getWriter().println("Uploaded: " + uuid);
    }

    private boolean isValid(String token) {
        return "plzhalp".equals(token); // Implement tight security here
    }
}