@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/{provider}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Image> getImages(@PathVariable String provider) {
        return imageService.getImagesByProvider(provider);
    }

    @RequestMapping(value = "/{provider}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Image createNewImage(@PathVariable String provider, @RequestBody Image image) {
        return imageService.createImageForProvider(provider, image);
    }

    @RequestMapping(value = "/{provider}/images/{imageId}/start", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void startImageAtProvider(@PathVariable String provider, @PathVariable String imageId) {
        return imageService.startImageAtProvider(provider, imageId);
    }

}