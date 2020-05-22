@ResponseBody
@RequestMapping(value = "/download/{fileaddress}", method = RequestMethod.GET)
public Object download(@PathVariable(value = "fileaddress") String fileaddress, RedirectAttributes redirectAttrs) throws Exception {
    if(StringUtils.hasText(fileaddress)){
        try{
            // Get the remove file based on the fileaddress
            RemoteFile remotefile = new RemoteFile(fileaddress);

            // Set the input stream
            InputStream inputstream = remotefile.getInputStream();
            // asume that it was a PDF file
            HttpHeaders responseHeaders = new HttpHeaders();
            InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
            responseHeaders.setContentLength(contentLengthOfStream);
            responseHeaders.setContentType(MediaType.valueOf("application/pdf"));
            return new ResponseEntity<InputStreamResource> (inputStreamResource,
                                       responseHeaders,
                                       HttpStatus.OK);
         } catch (MyExceptionA | MyExceptionB | MyExceptionC | MyExceptionD ex) {
           redirectAttrs.addFlashAttribute("error", ex.getMessage());
         }        
    } else {
        redirectAttrs.addFlashAttribute("error", "File name is required");
    }
    return "redirect:/addresses";
}