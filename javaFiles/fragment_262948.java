@RequestMapping(value="/filestore/{bucketuuid}/appsport.com/listOfObjectsWithSingleFile/{folder}", method = RequestMethod.POST)
@ResponseBody
public String listOfObjectsWithSingleFile(@PathVariable(name="bucket-uuid", required = true) String bucketUUId,
    @PathVariable(name="folder", required = false) String folder,Set<FileWithObject> rawData) {
    return pingResponse;
}