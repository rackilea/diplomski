@ResponseBody
@RequestMapping(value = "/tag/tagList", method = RequestMethod.POST)
public String saveTagList(@RequestBody TagListRequest request) {
    System.out.println(request.getTagTexts());
    String response = tagService.saveTags(request.getTagTexts());
    return response;
}