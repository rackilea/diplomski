@RequestMapping(path = "/most-popular", method = GET)
@Override
public List<RefinedAlbum> getMostPopular (@RequestParam("limit") int limit, 
   @RequestParam("offset") int offset) {
   inputValidation(limit, offset);
   return albumService.getMostPopular(limit, offset);
}