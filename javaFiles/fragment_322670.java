@RequestMapping(value="/upload", method = RequestMethod.POST, produces="application/json")
public @ResponseBody
ServerResponse handleUploadedFiles(@RequestParam(value = "file") MultipartFile file,
                                   @RequestParam(value="token") String token, 
                                   @MethodBean SoftwareCommunicationService softwareCommunicationService,
                                   @MethodBean FileOperationsService fileOperationsService, 
                                   @MethodBean ServerResponse serverResponse )throws IOException {