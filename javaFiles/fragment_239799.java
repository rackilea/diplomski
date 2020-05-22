@RequestMapping(
        value = "/download/{fileName:.+}",
        method = RequestMethod.GET,
        produces = "application/zip")
@ResponseBody
public FileSystemResource download(@PathVariable("fileName") String fileName) {
...
}