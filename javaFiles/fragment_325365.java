@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
public @ResponseBody String uploadFile(MultipartFile file, HttpServletRequest req)
        throws SQLException {

    // using file.

    return "success";
}