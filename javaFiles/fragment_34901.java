@RestController
@RequestMapping("/api")
public class DownloadsController {

    @GetMapping("/getFile")
    public ResponseEntity<Resource> getFile(HttpServletResponse httpServletResponse) throws FileNotFoundException{
        File file = new File("/home/sagara/Downloads/3.vector.pbf");
        HttpHeaders headers = new HttpHeaders();
        String fileName = file.getName();
        headers.add("Content-disposition","attachment; filename="+ fileName);
        Resource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
            .headers(headers)
            .contentLength(file.length())
            .contentType(MediaType.parseMediaType("application/x-protobuf"))
            .body(resource);
    }
}