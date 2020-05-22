@RequestMapping(value = "/upload.do", method = {RequestMethod.POST})
public String addEditLocationToCompany(Model model
   ,@RequestParam("description")String desc
   ,@RequestParam(value="locationMapFile", required=false) CommonsMultipartFile locationMapFileData, MultipartHttpServletRequest mrequest)
{
String value = mrequest.getParameter("setting_14");
}