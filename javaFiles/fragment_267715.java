import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RequestMapping(path = "/images/{imageId}", method = RequestMethod.GET)
@ResponseBody
public ResponseEntity<Resource> getImage(@PathVariable Long imageId) {
    try {

        File file = imageService.getImage(imageId);

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok().contentLength(file.length()).contentType(MediaType.IMAGE_JPEG).body(resource);
    } catch (Exception e) {
        throw new InternalServerException("Unable to generate image");
    }
}