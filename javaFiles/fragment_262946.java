@RequestMapping(value="/filestore/{bucket-uuid}/appsport.com/listOfObjectsWithSingleFile/{folder}",
        method = RequestMethod.POST)
@ResponseBody
public String listOfObjectsWithSingleFile(
        @PathVariable(name="bucket-uuid") String bucketUUId, @PathVariable(name="folder") String folder,
        FileWithObject objects) { // change this Set<FileWithObject> rawData to FileWithObject objects
    return pingResponse;
}