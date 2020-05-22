import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/generate_pdf")
public class PdfController {

    @GetMapping(value = "/online", /*this is "nice to have" ->*/ produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody // this is important, as the return type byte[]
    public byte[] generating_pdf() throws IOException {//exception handling...
        System.out.println("hello");//logging
        // re-generate new file if needed (thread-safety!)...
        // ..and dump the content as byte[] response body:
        return Files.readAllBytes(Paths.get("d:\\sanjeet7.pdf"));
    }
}