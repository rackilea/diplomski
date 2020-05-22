@RequestMapping(value = "/classified/{idClassified}/dealer/{idPerson}/upload",
    method = RequestMethod.POST)
@ResponseBody
public final String uploadClassifiedPicture(
    @PathVariable int idClassified,
    @PathVariable int idPerson, 
    @RequestParam String token, 
    @RequestParam MultipartFile content);