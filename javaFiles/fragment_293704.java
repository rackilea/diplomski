@RequestMapping(value = "/upload", method = RequestMethod.POST)
public void uploadingFile(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {

    Iterator<String> itr =  request.getFileNames();

    MultipartFile file = request.getFile(itr.next());
    System.out.println(file.getOriginalFilename() +" uploaded!");
}